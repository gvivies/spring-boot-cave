package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Classification;
import com.gvivies.cave.repositories.ClassificationRepository;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Autowired
	private ClassificationRepository classifRepository;

	@Autowired
	private BottleService bottleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Classification> findAll() {
		String owner = userService.getAuthenticatedUserId();
		return classifRepository.findByOwnedByOrderByName(owner);
	}

	public List<Classification> findAllWithBottleCount() {
		List<Classification> classifications = this.findAll();
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
		return classifRepository.findOne(id);
	}

	@Override
	public void delete(Classification classification) {
		classifRepository.delete(classification);
		
	}

	@Override
	public Classification save(Classification classification) {
		return classifRepository.save(classification);
	}

	@Override
	public Classification insert(Classification classification) {
		return classifRepository.insert(classification);
	}
	
	@Override
	public void deleteAllForUser(String owner) {
		mongoTemplate.remove(Query.query(where("ownedBy").is(owner)), Classification.class);	
	}
}
