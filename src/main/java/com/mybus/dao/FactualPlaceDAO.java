package com.mybus.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.FactualPlace;

@Repository
public interface FactualPlaceDAO extends PagingAndSortingRepository<FactualPlace, String> {
	 Page<FactualPlace> findAll(Pageable pageable);
	 
	   
}
