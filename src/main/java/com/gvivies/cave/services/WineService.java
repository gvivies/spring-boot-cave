package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Wine;

public interface WineService {
	public List<Wine> findAll(); 
	public List<Wine> findAllByRegion(String region); 
	public List<Wine> findAllWithBottleCount();
	public Wine findOne(String id);
	public void delete(Wine wine);
	public Wine save(Wine wine);
	public Wine insert(Wine wine);
}
