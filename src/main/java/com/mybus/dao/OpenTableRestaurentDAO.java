package com.mybus.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.OpenTableRestaurent;

@Repository
public interface OpenTableRestaurentDAO extends PagingAndSortingRepository<OpenTableRestaurent, String> {

}
