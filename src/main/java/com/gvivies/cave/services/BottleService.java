package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Bottle;

public interface BottleService {
	public List<Bottle> findAll();
	public Bottle findOne(String id);
	public long countAll();
	public void delete(Bottle bottle);
	public Bottle save(Bottle bottle);
	public Bottle insert(Bottle bottle);
}
