package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Classification;
import com.gvivies.cave.services.ClassificationService;

@RestController
@RequestMapping("/classifications")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class ClassificationController {
	
	@Autowired
	private ClassificationService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Classification> list() {	
		return service.findAllWithBottleCount();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Classification save(@RequestBody Classification classification ) {
		return service.insert(classification);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Classification update(@RequestBody Classification classification ) {
		return service.save(classification);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Classification classification = service.findOne(id);
		if (classification!= null) {
			service.delete(classification);
		}	 
	}
}
