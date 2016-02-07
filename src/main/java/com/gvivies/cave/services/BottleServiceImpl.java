package com.gvivies.cave.services;

import java.util.IntSummaryStatistics;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.repositories.BottleRepository;

@Service
public class BottleServiceImpl implements BottleService {

	@Autowired
	private BottleRepository repository;
	
	@Override
	public long countAll() {
		IntSummaryStatistics stats = repository.findAll().stream()
				.map(r -> r.getQuantity())
				.mapToInt((x) -> x)
				.summaryStatistics();
			return stats.getSum();

	}

	@Override
	public List<Bottle> findAll() {
		return repository.findAll();
	}
	
	

}
