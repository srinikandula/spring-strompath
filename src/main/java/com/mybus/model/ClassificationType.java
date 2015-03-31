package com.mybus.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "ClassificationType")
public class ClassificationType {

	public static final String KEY_ID = "_id";
	  
	@Id
	@Getter
	@Setter
	@Field(KEY_ID)
	@ApiObjectField(description = "ID of the Object")
	private String id;
	
	@Getter
	@Setter
	private String name;
}
