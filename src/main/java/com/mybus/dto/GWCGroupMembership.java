package com.mybus.dto;

import lombok.Getter;
import lombok.Setter;

import com.mybus.model.GWCGroup;
import com.stormpath.sdk.group.GroupMembership;

public class GWCGroupMembership {

	@Getter
	@Setter
	private String href;
	@Getter
	@Setter
	private GWCGroup group;
	
	public GWCGroupMembership(GroupMembership groupMembership) {
		this.href = groupMembership.getHref();
		this.group = GWCGroup.build(groupMembership.getGroup());
	}

	public void delete() {
		throw new RuntimeException("GWCGroupMembership.delete() is not implemented yet");
		
	}
}
