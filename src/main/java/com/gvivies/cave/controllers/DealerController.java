package com.gvivies.cave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.services.DealerService;

@RestController
@RequestMapping("/dealers")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class DealerController {
	
	@Autowired 
	private DealerService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Dealer> list() {
		List<Dealer> dealers = service.findAll();
		return dealers;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Dealer save(@RequestBody Dealer dealer ) {
		return service.insert(dealer);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Dealer update(@RequestBody Dealer dealer ) {
		return service.save(dealer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Dealer dealer = service.findOne(id);
		if (dealer!= null) {
			service.delete(dealer);
		}	 
	}
}
