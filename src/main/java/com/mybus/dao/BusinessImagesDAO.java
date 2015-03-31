package com.mybus.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybus.model.BusImages;

@Repository
public interface BusinessImagesDAO extends PagingAndSortingRepository<BusImages, String> {

	BusImages findByBusinessId(String businessId);
    Page<BusImages> findAll(Pageable pageable);
}
