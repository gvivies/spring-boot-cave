package com.gvivies.cave.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.Wine;

public interface WineRepository extends MongoRepository<Wine, String> {

	public List<Wine> findAll();
	public Wine findByName(String name);
	
}
