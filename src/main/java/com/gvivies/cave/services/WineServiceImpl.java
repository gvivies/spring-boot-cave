package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;

@Service
public class WineServiceImpl implements WineService {

	private Log log = LogFactory.getLog(WineServiceImpl.class);

	@Autowired
	private WineRepository wineRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired 
	private BottleService bottleService;

	@Autowired
	private MongoTemplate mongoTemplate;

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
		List<Wine> wines = new ArrayList<Wine>();
		List<Wine> winesOfRegion = mongoTemplate.find(orderedBy("name"), Wine.class);
		wines.addAll(winesOfRegion);
		addBottleCountTo(wines);
		return wines;
	}

	private Query orderedBy(String col) {
		return Query.query(new Criteria()).with(new Sort(Sort.Direction.ASC, col));	
	}
	
	private List<Region> retrieveRegions(String region) {
		List<Region> regions = new ArrayList<Region>();
		if (region == null || region.isEmpty()) {
			regions = regionRepository.findAll();
		} else {
			regions.add(regionRepository.findByName(region));
		}
		return regions;
	}
	
	public List<Wine> findAllWithBottleCount() {
		List<Wine> wines = wineRepository.findAll();
		addBottleCountTo(wines);
		return wines;
	}
	
	private void addBottleCountTo(List<Wine> wines) {
		List<Bottle> allBottles = bottleService.findAll();	
		wines.forEach(c -> c.setQuantity(allBottles.stream() //
				.filter(b -> c.getId().equals(b.getWine().getId())) //
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

}
