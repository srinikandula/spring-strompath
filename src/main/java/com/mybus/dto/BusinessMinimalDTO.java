package com.mybus.dto;

import com.mybus.model.Businesses;

import lombok.Getter;
import lombok.Setter;

public class BusinessMinimalDTO {

	@Getter
	@Setter
	private String id;
	
	@Getter
	@Setter
	private String displayName;
	
	public BusinessMinimalDTO(Businesses businesses){
		this.setId(businesses.getId());
		this.setDisplayName(businesses.getName());
	}
}
