package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.repositories.BottleRepository;

@Service
public class BottleServiceImpl implements BottleService {

	@Autowired
	private BottleRepository bottleRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public long countAll() {
		String owner = userService.getAuthenticatedUserId();
		IntSummaryStatistics stats = bottleRepository.findByOwnedBy(owner).stream()
				.map(r -> r.getQuantity())
				.mapToInt((x) -> x)
				.summaryStatistics();
			return stats.getSum();
	}

	@Override
	public List<Bottle> findAll() {
		String owner = userService.getAuthenticatedUserId();
		List<Bottle> bottlesInCellar = bottleRepository.findByOwnedBy(owner) //
				.stream() //
				.filter(b -> !b.isOrdered()) //
				.collect(Collectors.toList());
		return bottlesInCellar;
	}
	
	@Override
	public List<Bottle> findAllOrdered() {
		String owner = userService.getAuthenticatedUserId();
		List<Bottle> orderedBottles = bottleRepository.findByOwnedBy(owner) //
				.stream() //
				.filter(b -> b.isOrdered()) //
				.collect(Collectors.toList());
		return orderedBottles;
	}

	@Override
	public void delete(Bottle bottle) {
		bottleRepository.delete(bottle);		
	}

	@Override
	public Bottle save(Bottle bottle) {
		return bottleRepository.save(bottle);
	}

	@Override
	public Bottle insert(Bottle bottle) {
		return bottleRepository.insert(bottle);
	}

	@Override
	public Bottle findOne(String id) {
		return bottleRepository.findOne(id);
	}

	@Override
	public void deleteAllForUser(String owner) {
		mongoTemplate.remove(Query.query(where("ownedBy").is(owner)), Bottle.class);	
	}
	
	

}
