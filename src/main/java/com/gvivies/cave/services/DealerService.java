package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Dealer;

public interface DealerService {
	public List<Dealer> findAll();
	public Dealer findOne(String id);
	public void delete(Dealer dealer);
	public Dealer save(Dealer dealer);
	public Dealer insert(Dealer dealer);
}
