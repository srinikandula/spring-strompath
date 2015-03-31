package com.mybus.model;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountCriteria;
import com.stormpath.sdk.account.AccountList;
import com.stormpath.sdk.directory.AccountStoreVisitor;
import com.stormpath.sdk.directory.CustomData;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupMembership;
import com.stormpath.sdk.group.GroupMembershipList;
import com.stormpath.sdk.group.GroupOptions;
import com.stormpath.sdk.group.GroupStatus;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "name" })
@ApiObject(name = "GWCGroup")
public class GWCGroup implements com.stormpath.sdk.group.Group {
	
	@Getter
	@Setter
	@ApiObjectField(description = "Group Name")
	private String name;

	@Getter
	@Setter
	@ApiObjectField(description = "Group href")
	private String href;

	@Getter
	@Setter
	@ApiObjectField(description = "Group Description")
	private String description;
	
	@Getter
	@Setter
	@ApiObjectField(description = "Group Tenant")
	private GWCTenant tenant;

	@Getter
	@Setter
	@ApiObjectField(description = "Group Directory")
	private Directory directory;

	
	@Setter
	@ApiObjectField(description = "Group customdata")
	private CustomData customData;


	@ApiObjectField(description = "Group status")
	private GroupStatus status;
	
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountList getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupMembership addAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static GWCGroup build(Group group) {
		GWCGroup g = new GWCGroup();
		g.setDescription(group.getDescription());
		g.setName(group.getName());
		g.setHref(group.getHref());
		g.setStatus(group.getStatus());
		g.setTenant(GWCTenant.build(group.getTenant()));
		return g;
	}
	public GWCGroup() {
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(AccountStoreVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Group setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public GroupStatus getStatus() {
		return this.status;
	}

	@Override
	public Group setStatus(GroupStatus status) {
		this.status = status;
		return this;
	}

	

	@Override
	public AccountList getAccounts(Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountList getAccounts(AccountCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupMembershipList getAccountMemberships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveWithResponseOptions(GroupOptions responseOptions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomData getCustomData() {
		return this.customData;
	}

}
