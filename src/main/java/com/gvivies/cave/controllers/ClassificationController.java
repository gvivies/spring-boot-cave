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
	private ClassificationService classifService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Classification> list() {	
		return classifService.findAllWithBottleCount();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Classification save(@RequestBody Classification classification ) {
		return classifService.insert(classification);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Classification update(@RequestBody Classification classification ) {
		return classifService.save(classification);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Classification classification = classifService.findOne(id);
		if (classification!= null) {
			classifService.delete(classification);
		}	 
	}
}
