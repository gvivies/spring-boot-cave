package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.WineRepository;
import com.gvivies.cave.services.WineService;

@RestController
@RequestMapping("/wines")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class WineController {

	@Autowired
	private WineRepository repository;
	
	@Autowired
	private WineService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Wine> list() {
		List<Wine> wines = service.findAll();
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
