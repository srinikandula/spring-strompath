package com.mybus.service;

import static com.mybus.model.AbstractDocument.KEY_ID;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mybus.model.Classifications;
import com.mongodb.WriteResult;

@Service
public class ClassificationsService {
	private static final Logger logger = LoggerFactory.getLogger(ClassificationsService.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean updateClassification(String classificationId, String name) {
		if (name == null) {
			throw new NullPointerException("name was null");
		}

		if (logger.isTraceEnabled()) {
			logger.trace(String.format("updateClassification(%s, %s)", classificationId, name));
		}
		Query query = new Query().addCriteria(where(KEY_ID).is(classificationId));
		Update update = new Update().set("name", name);
		WriteResult writeResult = mongoTemplate.updateFirst(query, update, Classifications.class);
		return writeResult.getError() == null;
	}
}
