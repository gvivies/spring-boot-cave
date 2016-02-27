package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.repositories.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private BottleService bottleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Region> findAll() {
		String owner = userService.getAuthenticatedUserId();
		return regionRepository.findByOwnedByOrderByName(owner);
	}

	@Override
	public List<Region> findAllWithBottleCount() {
		String owner = userService.getAuthenticatedUserId();
		List<Region> regions = regionRepository.findByOwnedByOrderByName(owner);
		addBottleCountTo(regions);
		return regions;
	}

	private void addBottleCountTo(List<Region> regions) {
		List<Bottle> bottles = bottleService.findAll();
		regions.forEach(r -> r.setQuantity(bottles.stream() //
					.filter(b -> r.getId().equals(b.getWine().getRegion().getId()))  //
					.map(b -> b.getQuantity()) //
					.mapToInt((x) -> x) //
					.sum()));	
	}

	@Override
	public Region findOne(String id) {
		return regionRepository.findOne(id);
	}
	
	@Override
	public void delete(Region region) {
		regionRepository.delete(region);

	}

	@Override
	public Region save(Region region) {
		return regionRepository.save(region);
	}

	@Override
	public Region insert(Region region) {
		return regionRepository.insert(region);
	}

	@Override
	public void deleteAllForUser(String owner) {
		mongoTemplate.remove(Query.query(where("ownedBy").is(owner)), Region.class);	
	}

}
