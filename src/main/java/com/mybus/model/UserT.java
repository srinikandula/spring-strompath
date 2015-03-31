package com.mybus.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "email" })
@ApiObject(name = "User")
public class UserT extends AbstractDocument implements AttributesDocument,Serializable {@Override
	public boolean containsKey(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
