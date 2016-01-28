package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.WineRepository;

@RestController
@RequestMapping("/wines")
public class WineController {

	@Autowired
	private WineRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Wine> list() {
		List<Wine> wines = repository.findAll();
		return wines;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Wine save(@RequestBody Wine wine ) {
		repository.insert(wine);
		return wine;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Wine update(@RequestBody Wine wine ) {
		repository.save(wine);
		return wine;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Wine wine = repository.findOne(id);
		if (wine!= null) {
			repository.delete(wine);
		}	 
	}
}
