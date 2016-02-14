package com.gvivies.cave.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Classification;
import com.gvivies.cave.repositories.ClassificationRepository;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Autowired
	private ClassificationRepository repository;

	@Autowired
	private BottleService bottleService;

	public List<Classification> findAll() {
		return repository.findAll();
	}

	public List<Classification> findAllWithBottleCount() {
		List<Classification> classifications = repository.findAll();
		addBottleCountTo(classifications);
		return classifications;
	}
	
	private void addBottleCountTo(List<Classification> classifications) {
		List<Bottle> allBottles = bottleService.findAll();	
		classifications.forEach(c -> c.setQuantity(allBottles.stream() //
				.filter(b -> c.getId().equals(b.getClassification().getId())) //
				.map(b -> b.getQuantity()) //
				.mapToInt((x) -> x) //
				.sum()));		
	}

	@Override
	public Classification findOne(String id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Classification classification) {
		repository.delete(classification);
		
	}

	@Override
	public Classification save(Classification classification) {
		return repository.save(classification);
	}

	@Override
	public Classification insert(Classification classification) {
		return repository.insert(classification);
	}
}
