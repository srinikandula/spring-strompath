package com.mybus.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.NeighborhoodGeos;

@Repository
public interface NeighborhoodGeosDAO extends PagingAndSortingRepository<NeighborhoodGeos, String> {
     Page<NeighborhoodGeos> findAll(Pageable pageable);
     Page<NeighborhoodGeos> findByName(String name, Pageable pageable);
}
