package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Wine;

public interface WineService {

	public List<Wine> findAllByRegion(String region); 
	
}
