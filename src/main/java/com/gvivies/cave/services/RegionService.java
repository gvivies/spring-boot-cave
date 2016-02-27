package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Region;

public interface RegionService {
	List<Region> findAll();
	List<Region> findAllWithBottleCount();
	Region findOne(String id);
	void delete(Region region);
	void deleteAllForUser(String owner);
	Region save(Region region);
	Region insert(Region region);	
}
