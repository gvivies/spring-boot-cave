package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Bottle;
import com.gvivies.cave.services.BottleService;

@RestController
@RequestMapping("/bottles")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class BottleController {
	
	@Autowired
	private BottleService bottleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Bottle> list() {
		List<Bottle> bottles = bottleService.findAll();
		return bottles;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Bottle save(@RequestBody Bottle bottle ) {
		return bottleService.insert(bottle);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Bottle update(@RequestBody Bottle bottle ) {
		return bottleService.save(bottle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Bottle bottle = bottleService.findOne(id);
		if (bottle!= null) {
			bottleService.delete(bottle);
		}	 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/drink")
	public Bottle drink(@RequestBody Bottle bottle) {
		bottle.setQuantity(bottle.getQuantity() - 1);
		return bottleService.save(bottle);				
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/countall")
	public long countAll() {
		return bottleService.countAll();
	} 

}
