package com.gvivies.cave.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.Wine;

public interface WineRepository extends MongoRepository<Wine, String> {

	public List<Wine> findByOwnedByOrderByName(String ownedBy);
	public Wine findByNameAndOwnedBy(String name, String ownedBy);
	
}
