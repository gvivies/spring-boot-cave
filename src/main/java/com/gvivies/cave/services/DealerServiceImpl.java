package com.gvivies.cave.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.repositories.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerRepository repository;
	
	@Override
	public List<Dealer> findAll() {
		return repository.findAll();
	}

	@Override
	public Dealer findOne(String id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Dealer dealer) {
		repository.delete(dealer);
	}

	@Override
	public Dealer save(Dealer dealer) {
		return repository.save(dealer);
	}

	@Override
	public Dealer insert(Dealer dealer) {
		return repository.insert(dealer);
	}

}
