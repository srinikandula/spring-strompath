package com.mybus.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.FactualResponse;

@Repository
public interface FactualResponseDAO extends PagingAndSortingRepository<FactualResponse, String> {

    Page<FactualResponse> findAll(Pageable pageable);


}
