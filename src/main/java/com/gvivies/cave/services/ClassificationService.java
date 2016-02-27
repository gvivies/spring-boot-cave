package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Classification;

public interface ClassificationService {
	List<Classification> findAll();
	List<Classification> findAllWithBottleCount();
	Classification findOne(String id);	
	void delete(Classification classification);
	void deleteAllForUser(String owner);
	Classification save(Classification classification);
	Classification insert(Classification classification);
}
