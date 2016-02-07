package com.gvivies.cave.controllers;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.repositories.BottleRepository;
import com.gvivies.cave.services.BottleService;
import com.gvivies.cave.services.RegionService;

@RestController
@RequestMapping("/bottles")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class BottleController {

	@Autowired
	private BottleRepository repository;
	
	@Autowired
	private BottleService bottleService;
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Bottle> list() {
		List<Bottle> bottles = repository.findAll();
		return bottles;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Bottle save(@RequestBody Bottle bottle ) {
		repository.insert(bottle);
		return bottle;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Bottle update(@RequestBody Bottle bottle ) {
		repository.save(bottle);
		return bottle;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Bottle bottle = repository.findOne(id);
		if (bottle!= null) {
			repository.delete(bottle);
		}	 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/drink")
	public Bottle drink(@RequestBody Bottle bottle) {
		bottle.setQuantity(bottle.getQuantity() - 1);
		repository.save(bottle);				
		return bottle;
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/countall")
	public long countAll() {
		return bottleService.countAll();

	} 

}
