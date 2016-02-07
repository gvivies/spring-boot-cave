package com.gvivies.cave.services;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;

@Service
public class WineServiceImpl implements WineService {

	private Log log = LogFactory.getLog(WineServiceImpl.class);

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Wine> findAllByRegion(String region) {

		List<Wine> wines = new ArrayList<Wine>();
		retrieveRegions(region).forEach(t -> {
			Query query = Query.query(where("region").is(t));
			query.with(new Sort(Sort.Direction.ASC, "_id"));
			List<Wine> winesOfRegion = mongoTemplate.find(query, Wine.class);
			wines.addAll(winesOfRegion);
			log.debug("Region : " + ((t == null) ? "null" : t.getName()) + "(" + winesOfRegion.size() + ")");
		});
		return wines;
	}

	@Override
	public List<Wine> findAll() {
		List<Wine> wines = new ArrayList<Wine>();
		Query query = Query.query(new Criteria());
		query.with(new Sort(Sort.Direction.ASC, "name"));
		List<Wine> winesOfRegion = mongoTemplate.find(query, Wine.class);
		wines.addAll(winesOfRegion);
		return wines;
	}

	private List<Region> retrieveRegions(String region) {
		List<Region> regions = new ArrayList<Region>();
		if (region == null || region.isEmpty()) {
			regions = regionRepository.findAll();
		} else {
			regions.add(regionRepository.findByName(region));
		}
		log.info("Regions count : " + regions.size());
		return regions;
	}

}
