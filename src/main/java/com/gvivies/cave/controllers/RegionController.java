package com.gvivies.cave.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Region;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.services.RegionService;

@RestController
@RequestMapping("/regions")
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class RegionController {

	@Autowired
	private RegionRepository repository;

	@Autowired
	private RegionService regionService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Region> list() {
		List<Region> regions = repository.findAll();
		return regions;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Region save(@RequestBody Region region ) {
		repository.insert(region);
		return region;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Region update(@RequestBody Region region ) {
		repository.save(region);
		return region;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	  public void delete(@PathVariable String id) {
		Region region = repository.findOne(id);
		if (region!= null) {
			repository.delete(region);
		}	 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/withcount")
	public List<Region> countPerRegion() {
		return regionService.findAllWithSum();
	} 
}
