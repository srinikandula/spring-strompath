package com.mybus.dao.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mybus.model.FactualPlace;

@Repository
public class FactualPlaceDAOImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Iterable<FactualPlace> findByFactualId(String factualid) {
		Query query = new Query().addCriteria(where("factual_id").is(factualid));
		return mongoTemplate.find(query, FactualPlace.class);
	}
}
