package com.mybus.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.Classifications;

@Repository
public interface ClassificationsDAO extends PagingAndSortingRepository<Classifications, String> {
     Page<Classifications> findAll(Pageable pageable);
     Page<Classifications> findByName(String name, Pageable pageable);
}
