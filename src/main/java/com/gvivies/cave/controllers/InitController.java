package com.gvivies.cave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Classification;
import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.ClassificationRepository;
import com.gvivies.cave.repositories.DealerRepository;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;
import com.gvivies.cave.services.DataService;

@RestController
@RequestMapping("/initcave/{owner}")
public class InitController {

	@Autowired
	private DataService dataService;
	
	@RequestMapping(method=RequestMethod.GET)
	private void initForUser(@PathVariable String owner) {
		dataService.initForUser(owner);
	}

}
