package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Bottle;

public interface BottleService {
	public List<Bottle> findAll();
	public long countAll();
}
