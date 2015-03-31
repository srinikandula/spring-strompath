package com.mybus.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.Businesses;

@Repository
public interface BusinessesDAO extends PagingAndSortingRepository<Businesses, String> {
	
	List<Businesses> findAll();
	 
    Page<Businesses> findAll(Pageable pageable);

	Page<Businesses> findByCategoryIds(String categoryId, Pageable page);

	Page<Businesses> findByCategoryIdsAndPublishedIgnoreCaseAndNameContaining(String categoryId, String published, String name,
			Pageable page);

	Page<Businesses> findByCategoryIdsAndPublishedIgnoreCase(String categoryId, String published, Pageable page);

	Page<Businesses> findByCategoryIdsAndNameContaining(String categoryId, String name, Pageable page);

	Page<Businesses> findByPublishedIgnoreCaseAndNameContaining(String published, String name, Pageable page);

	Page<Businesses> findByNameContaining(String name, Pageable page);

	Page<Businesses> findByPublishedIgnoreCase(String published, Pageable page);
   
}
