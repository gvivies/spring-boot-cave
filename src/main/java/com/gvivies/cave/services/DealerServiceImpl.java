package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.repositories.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerRepository dealerRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Dealer> findAll() {
		String owner = userService.getAuthenticatedUserId();
		return dealerRepository.findByOwnedBy(owner);
	}

	@Override
	public Dealer findOne(String id) {
		return dealerRepository.findOne(id);
	}

	@Override
	public void delete(Dealer dealer) {
		dealerRepository.delete(dealer);
	}

	@Override
	public Dealer save(Dealer dealer) {
		return dealerRepository.save(dealer);
	}

	@Override
	public Dealer insert(Dealer dealer) {
		return dealerRepository.insert(dealer);
	}

	@Override
	public void deleteAllForUser(String owner) {
		mongoTemplate.remove(Query.query(where("ownedBy").is(owner)), Dealer.class);	
	}
}
