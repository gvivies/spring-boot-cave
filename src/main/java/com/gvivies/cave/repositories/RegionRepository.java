package com.gvivies.cave.repositories;

import com.gvivies.cave.model.Region;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region, String> {
	
	public Region findByName();
	public List<Region> findAll();
	
}
