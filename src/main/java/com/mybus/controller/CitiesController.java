package com.mybus.controller;

import com.google.common.collect.Lists;
import com.mybus.controller.utils.ControllerUtils;
import com.mybus.dao.NeighborhoodGeosDAO;
import com.mybus.model.NeighborhoodGeos;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/")
public class CitiesController {
	
	@Autowired
	private NeighborhoodGeosDAO neighborhoodGeosDAO;

	
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "neighborhoodGeos", method = RequestMethod.GET, produces = ControllerUtils.JSON_UTF8)
    @ResponseBody
    @ApiResponseObject
    public List<NeighborhoodGeos> getNeighborhoodGeos(
    		@RequestParam(value = "isPortal", required = false) final String isPortal,
    		@RequestParam(value = "geo", required = false) final boolean geo) {
		Iterable<NeighborhoodGeos> neighborhoodGeos = neighborhoodGeosDAO.findAll();
		List<NeighborhoodGeos> list = Lists.newArrayList(neighborhoodGeos);
		return list;
	}
	


}
