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
import com.stormpath.sdk.account.CreateAccountRequest;
import com.stormpath.sdk.directory.AccountStoreVisitor;
import com.stormpath.sdk.directory.DirectoryStatus;
import com.stormpath.sdk.group.CreateGroupRequest;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupCriteria;
import com.stormpath.sdk.group.GroupList;
import com.stormpath.sdk.provider.Provider;
import com.stormpath.sdk.tenant.Tenant;


@ToString
@EqualsAndHashCode(callSuper = false, of = { "name" })
@ApiObject(name = "Directory")
public class Directory implements com.stormpath.sdk.directory.Directory{
	public Directory(com.stormpath.sdk.directory.Directory copy) {
		this.setHref(copy.getHref());
		this.setName(copy.getName());
		this.setStatus(copy.getStatus());
		this.setDescription(copy.getDescription());
		// TODO Auto-generated constructor stub
	}
	
	@Getter
    @Setter
    @ApiObjectField(description = "Directory href")
    private String href;
	
	
	@Getter
    @Setter
    @ApiObjectField(description = "Name")
    private String name;
	
	
	@Getter
    @Setter
    @ApiObjectField(description = "Description")
    private String description;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount(Account account, boolean registrationWorkflowEnabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountList getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupList getGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant getTenant() {
		// TODO Auto-generated method stub
		return null;
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
	public com.stormpath.sdk.directory.Directory setName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.stormpath.sdk.directory.Directory setDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.stormpath.sdk.directory.Directory setStatus(DirectoryStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccount(CreateAccountRequest request) {
		// TODO Auto-generated method stub
		
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
	public GroupList getGroups(Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupList getGroups(GroupCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGroup(CreateGroupRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Provider getProvider() {
		// TODO Auto-generated method stub
		return null;
	}

}
