package com.gvivies.cave.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.Bottle;

public interface BottleRepository extends MongoRepository<Bottle, String> {

	public Bottle findByNameAndOwnedBy(String name, String ownedBy);
	public List<Bottle> findByOwnedBy(String ownedBy);
	
}
