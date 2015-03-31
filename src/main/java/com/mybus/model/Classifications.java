package com.mybus.model;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ApiObject(name = "Classifications")
public class Classifications extends AbstractDocument implements AttributesDocument {
	@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Getter
	@Setter
	@ApiObjectField(description = "Ids of the associated classifications")
	private Set<String> associatedClassificationIds;

	@Getter
	@Setter
	@ApiObjectField(description = "Name of classification")
	private String name;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Classification types")
	private Set<ClassificationType> types;
}
