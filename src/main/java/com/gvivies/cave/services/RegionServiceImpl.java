package com.gvivies.cave.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Bottle;
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
	public List<Region> findAllWithBottleCount() {
		List<Region> regions = repository.findAll();
		addBottleCountTo(regions);
		return regions;
	}

	private void addBottleCountTo(List<Region> regions) {
		List<Bottle> bottles = bottleService.findAll();
		regions.forEach(r -> r.setQuantity(bottles.stream() //
					.filter(b -> r.getId().equals(b.getWine().getRegion().getId()))  //
					.map(b -> b.getQuantity()) //
					.mapToInt((x) -> x) //
					.sum()));	
	}

	@Override
	public Region findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Region region) {
		repository.delete(region);

	}

	@Override
	public Region save(Region region) {
		return repository.save(region);
	}

	@Override
	public Region insert(Region region) {
		return repository.insert(region);
	}

}
