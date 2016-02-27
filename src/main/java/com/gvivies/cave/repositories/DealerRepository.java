package com.gvivies.cave.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.Dealer;

public interface DealerRepository extends MongoRepository<Dealer, String> {
	public Dealer findByNameAndOwnedBy(String name, String ownedBy);
	public List<Dealer> findByOwnedBy(String ownedBy);
}
