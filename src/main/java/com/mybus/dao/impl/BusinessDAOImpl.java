package com.mybus.dao.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mybus.dto.BusinessMinimalDTO;
import com.mybus.model.Businesses;

@Service
public class BusinessDAOImpl {

	@Autowired
	public MongoTemplate mongoTemplate;

	public Iterable<Businesses> findBusinesses(String categoryId, String categoryTypeId, String categorySubTypeId,
			String city, String conditionId, Float lat, Float lon, boolean featured, String name,
			String neighborhoodGeoIds, Float maxDistance, Integer pageSize, Integer pageNumber, String procedureId,
			String orderBy, String orderDir, String published, String search, String state) {
		Query query = buildQuery(categoryId, categoryTypeId, categorySubTypeId, city, 
				conditionId, lat, lon, featured, name, neighborhoodGeoIds, 
				maxDistance, pageSize, pageNumber, procedureId, 
				orderBy, orderDir, published, search, state);	
		
		return mongoTemplate.find(query, Businesses.class);
	}

	
	private Query buildQuery(String categoryId, String categoryTypeId, String categorySubTypeId, String city,
			String conditionId, Float lat, Float lon, boolean featured, String name, String neighborhoodGeoIds,
			Float maxDistance, Integer pageSize, Integer pageNumber, String procedureId, String orderBy,
			String orderDir, String published, String search, String state) {
		final Query query = new Query();
		if (!StringUtils.isBlank(categoryId)) {
			List<String> categories = new ArrayList<>(); // SK TODO fix this
															// criteria
			categories.add(categoryId);
			query.addCriteria(where("categoryIds").in(categories));
		}
		if (!StringUtils.isBlank(published) && !StringUtils.equals(published, "all")) {
			query.addCriteria(where("published").is(Boolean.parseBoolean(published)));
		}
		if (!StringUtils.isBlank(name)) {
			query.addCriteria(where("name").regex(name));
		}
		if (pageSize != null && pageNumber != null) {
			query.with(new PageRequest(pageNumber, pageSize));
		}
		if (!StringUtils.isBlank(orderBy)) {
			Sort sort = new Sort("ASC".equalsIgnoreCase(orderDir) ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy);
			query.with(sort);
		}
		// TODO: add other query criteria
		//query.fields().include("")
		return query;
	}

	public long countBusinesses(String categoryId, String categoryTypeId, String categorySubTypeId, String city,
			String conditionId, float lat, float lon, boolean featured, String neighborhood, float maxDistance,
			String published, String name, String procedureId) {
		Query query = buildQuery(categoryId, categoryTypeId, categorySubTypeId, city, conditionId, lat, lon, featured, name, null, 
				maxDistance, null, null, procedureId, null, null, published, null, null);
		return mongoTemplate.count(query, Businesses.class);
	}

	public List<BusinessMinimalDTO> findBusinessesMinimal(){
		Query q = new Query();
		q.fields().include("name").include("_id");
		Iterable<Businesses> all = mongoTemplate.find(q, Businesses.class);
		List<BusinessMinimalDTO> allDTOs = new ArrayList<>();
		for(Businesses b:all){
			allDTOs.add(new BusinessMinimalDTO(b));
		}
		return allDTOs;
	}


	
}
