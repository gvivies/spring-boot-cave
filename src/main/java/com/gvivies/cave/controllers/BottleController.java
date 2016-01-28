package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.repositories.BottleRepository;

@RestController
@RequestMapping("/bottles")
public class BottleController {

	@Autowired
	private BottleRepository repository;
	
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
}
