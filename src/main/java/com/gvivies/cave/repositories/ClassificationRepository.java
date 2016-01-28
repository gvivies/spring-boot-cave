package com.gvivies.cave.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.Classification;

public interface ClassificationRepository extends MongoRepository<Classification, String> {

	public Classification findByName();
	public List<Classification> findAll();
	
}
