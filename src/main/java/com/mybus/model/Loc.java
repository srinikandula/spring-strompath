package com.mybus.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.TypeAlias;

@ToString
@TypeAlias("loc")
@ApiObject(name = "Location")
public class Loc {
	@Getter
    @Setter
    @ApiObjectField(description = "Type of the location")
    private String type;

	@Getter
    @Setter
    @ApiObjectField(description = "Location co-ordinates")
    private String[] coordinates;
	
	public String getLongitude(){
		return getCoordinates()[0];
	}
	public String getLatitude(){
		return getCoordinates()[1];
	}
	
}
