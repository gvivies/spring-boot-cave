package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Region;

public interface RegionService {
	public List<Region> findAll();
	public List<Region> findAllWithSum();
}
