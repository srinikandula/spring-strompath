package com.mybus.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.json.JSONObject;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "OpenTableRestaurent")
public class OpenTableRestaurent {

	@Id @Getter @Setter
    @Field("_id")
    @ApiObjectField(description = "ID of the Object")
    private Integer id;
	
	@Setter
	@Getter
	private String city;
	
	@Setter
	@Getter
	private String restaurentName;
	
	
	@Setter
	@Getter
	private JSONObject restaurent;
}
