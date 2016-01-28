package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Classification;
import com.gvivies.cave.repositories.ClassificationRepository;

@RestController
@RequestMapping("/classifications")
public class ClassificationController {

	@Autowired
	private ClassificationRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Classification> list() {	
		return repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Classification save(@RequestBody Classification classification ) {
		repository.insert(classification);
		return classification;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Classification update(@RequestBody Classification classification ) {
		repository.save(classification);
		return classification;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Classification classification = repository.findOne(id);
		if (classification!= null) {
			repository.delete(classification);
		}	 
	}
}
