package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Wine;

public interface WineService {
	List<Wine> findAll(); 
	List<Wine> findAllByRegion(String region); 
	List<Wine> findAllWithBottleCount();
	Wine findOne(String id);
	void delete(Wine wine);
	void deleteAllForUser(String owner);
	Wine save(Wine wine);
	Wine insert(Wine wine);
}
