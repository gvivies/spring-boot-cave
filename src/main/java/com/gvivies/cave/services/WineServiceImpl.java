package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;

@Service
public class WineServiceImpl implements WineService {

	@Autowired
	private WineRepository wineRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired 
	private BottleService bottleService;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Wine> findAllByRegion(String region) {
		List<Wine> wines = new ArrayList<Wine>();
		retrieveRegions(region).forEach(t -> {
			Query query = Query.query(where("region").is(t));
			query.with(new Sort(Sort.Direction.ASC, "_id"));
			List<Wine> winesOfRegion = mongoTemplate.find(query, Wine.class);
			wines.addAll(winesOfRegion);
			addBottleCountTo(wines);
		});
		return wines;
	}

	@Override
	public List<Wine> findAll() {
		String owner = userService.getAuthenticatedUserId();
		List<Wine> wines = wineRepository.findByOwnedByOrderByName(owner);
		addBottleCountTo(wines);
		return wines;
	}
	
	private List<Region> retrieveRegions(String region) {
		String owner = userService.getAuthenticatedUserId();
		List<Region> regions = new ArrayList<Region>();
		if (region == null || region.isEmpty()) {
			regions = regionRepository.findByOwnedByOrderByName(owner);
		} else {
			regions.add(regionRepository.findByNameAndOwnedBy(region, owner));
		}
		return regions;
	}
	
	public List<Wine> findAllWithBottleCount() {
		List<Wine> wines = findAll();
		addBottleCountTo(wines);
		return wines;
	}
	
	private void addBottleCountTo(List<Wine> wines) {
		List<Bottle> allBottles = bottleService.findAll();	
		wines.forEach(c -> c.setQuantity(allBottles.stream() //
				.filter(b -> b.getWine() == null || c.getId().equals(b.getWine().getId())) //
				.map(b -> b.getQuantity()) //
				.mapToInt((x) -> x) //
				.sum()));		
	}

	@Override
	public Wine findOne(String id) {
		return wineRepository.findOne(id);
	}

	@Override
	public void delete(Wine wine) {
		wineRepository.delete(wine);
	}

	@Override
	public Wine save(Wine wine) {
		return wineRepository.save(wine);
	}

	@Override
	public Wine insert(Wine wine) {
		return wineRepository.insert(wine);
	}
	
	@Override
	public void deleteAllForUser(String owner) {
		mongoTemplate.remove(Query.query(where("ownedBy").is(owner)), Wine.class);	
	}

}
