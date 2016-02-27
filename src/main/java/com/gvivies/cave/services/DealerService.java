package com.gvivies.cave.services;

import java.util.List;

import com.gvivies.cave.model.Dealer;

public interface DealerService {
	List<Dealer> findAll();
	Dealer findOne(String id);
	void delete(Dealer dealer);
	void deleteAllForUser(String owner);
	Dealer save(Dealer dealer);
	Dealer insert(Dealer dealer);
}
