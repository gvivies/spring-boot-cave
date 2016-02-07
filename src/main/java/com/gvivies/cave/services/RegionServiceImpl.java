package com.gvivies.cave.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Region;
import com.gvivies.cave.repositories.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository repository;
	
	@Autowired
	private BottleService bottleService;
	
	@Override
	public List<Region> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Region> findAllWithSum() {
		Map<String, Integer> counts = new HashMap<String,Integer>();
		List<Region> regions = repository.findAll();
		bottleService.findAll().forEach(t -> {
			String region = t.getWine().getRegion().getId();
			int value = (counts.containsKey(region)) ? counts.get(region) + t.getQuantity() : t.getQuantity();
			counts.put(region, Integer.valueOf(value));
		});
		regions.forEach(t -> {
			t.setQuantity(counts.containsKey(t.getId()) ? counts.get(t.getId()) : 0);
		});
		return regions;
	}

}
