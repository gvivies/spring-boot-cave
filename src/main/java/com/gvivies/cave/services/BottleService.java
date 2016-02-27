package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Bottle;

public interface BottleService {
	List<Bottle> findAll();
	List<Bottle> findAllOrdered();
	Bottle findOne(String id);
	long countAll();
	void delete(Bottle bottle);
	void deleteAllForUser(String owner);
	Bottle save(Bottle bottle);
	Bottle insert(Bottle bottle);
}
