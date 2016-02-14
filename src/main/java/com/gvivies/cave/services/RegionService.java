package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Region;

public interface RegionService {
	public List<Region> findAll();
	public List<Region> findAllWithBottleCount();
	public Region findOne(String id);
	public void delete(Region region);
	public Region save(Region region);
	public Region insert(Region region);	
}
