package com.mybus.model;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.application.ApplicationCriteria;
import com.stormpath.sdk.application.ApplicationList;
import com.stormpath.sdk.application.CreateApplicationRequest;
import com.stormpath.sdk.directory.CreateDirectoryRequest;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.directory.DirectoryCriteria;
import com.stormpath.sdk.directory.DirectoryList;
import com.stormpath.sdk.resource.ResourceException;
import com.stormpath.sdk.tenant.Tenant;

@ToString
@EqualsAndHashCode(callSuper = false, of = { "name" })
@ApiObject(name = "Tenant")
public class GWCTenant implements com.stormpath.sdk.tenant.Tenant{	
	public static GWCTenant build(Tenant tenant) {
		GWCTenant t = new GWCTenant();
		t.setHref(tenant.getHref());
		t.setKey(tenant.getKey());
		t.setName(tenant.getName());
		return t;
	}
	@Getter
    @Setter
    @ApiObjectField(description = "Tenant href")
    private String href;
	
	
	@Getter
    @Setter
    @ApiObjectField(description = "Name")
    private String name;
	
	@Getter
    @Setter
    @ApiObjectField(description = "Key")
    private String key;
	
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ApplicationList getApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryList getDirectories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account verifyAccountEmail(String token) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Application createApplication(Application application) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Application createApplication(CreateApplicationRequest request) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ApplicationList getApplications(Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ApplicationList getApplications(ApplicationCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Directory createDirectory(Directory directory) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Directory createDirectory(CreateDirectoryRequest createDirectoryRequest) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DirectoryList getDirectories(Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DirectoryList getDirectories(DirectoryCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
