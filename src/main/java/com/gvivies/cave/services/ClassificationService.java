package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Classification;

public interface ClassificationService {
	public List<Classification> findAll();
	public List<Classification> findAllWithBottleCount();
	public Classification findOne(String id);	
	public void delete(Classification classification);
	public Classification save(Classification classification);
	public Classification insert(Classification classification);
}
