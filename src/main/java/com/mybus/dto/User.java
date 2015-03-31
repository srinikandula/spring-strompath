package com.mybus.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import com.mybus.model.GWCGroup;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.directory.CustomData;
import com.stormpath.sdk.group.Group;

public class User {
	
	
	@Getter
	@Setter
	@ApiObjectField(description = "Id")
	private String id;	

	@Getter
	@Setter
	@ApiObjectField(description = "href")
	private String href;
	
	@Getter
	@Setter
	@ApiObjectField(description = "First Name")
	private String firstName;

	@Getter
	@Setter
	@ApiObjectField(description = "Username i.e. unique identifier for the user")
	private String userName;

	@Getter
	@Setter
	@ApiObjectField(description = "Last Name")
	private String lastName;

	@Getter
	@Setter
	@ApiObjectField(description = "Full Name")
	private String fullName;

	@Getter
	@Setter
	@ApiObjectField(description = "Title")
	private String title;

	@Getter
	@Setter
	@NonNull
	@ApiObjectField(description = "Email Address")
	@Indexed(unique = true)
	private String email;

	@Getter
	@Setter
	@NonNull
	@Transient
	@ApiObjectField(description = "Password")
	private String password;

	@Getter
	@Setter
	@ApiObjectField(description = "States whether the user has an active account")
	private boolean active = true;

	@Getter
	@Setter
	@ApiObjectField(description = "States Whether User Is Administrator")
	private boolean admin;

	@Getter
	@Setter
	@ApiObjectField(description = "Last time the user logged in")
	private Date lastLoginTime;

	@Getter
	@Setter
	@ApiObjectField(description = "Login Status")
	private int loginStatus;

	@Getter
	@Setter
	@ApiObjectField(description = "True if the user has never logged in before")
	private boolean firstTimeUser;

	@Getter
	@Setter
	@ApiObjectField(description = "Verification link id")
	private String verificationLinkId;

	@Getter
	@Setter
	@Indexed
	// not unique because most will be null values
	private String apiKey;

	@Getter
	@Setter
	private String companyName;

	@Getter
	@Setter
	private String phone1;

	@Getter
	@Setter
	private String groupUrl;

	@Getter
	@Setter
	private String sptoken;

	@Getter
	@Setter
	private String groupName;

	@Getter
	@Setter
	private String confirmPassword;

	@Getter
	@Setter
	private String status;

	@Getter
	@Setter
	private String emailVerificationToken;

	@Getter
	@Setter
	private CustomData customData;

	@Getter
	@Setter
	private List<GWCGroup> groups;

	@Getter
	@Setter
	private List<GWCGroupMembership> groupMemberships;
	
	public User(Account account) {
		if (account != null) {
			setId(account.getUsername());
			setHref(account.getHref());
			setEmail(account.getEmail());
			setFirstName(account.getGivenName());
			setLastName(account.getSurname());
			setUserName(account.getUsername());
			setFullName(account.getGivenName() + " " + account.getSurname());
			this.customData = account.getCustomData();
			this.groups = new ArrayList<GWCGroup>();
			Iterator<com.stormpath.sdk.group.Group> userRoles = account.getGroups().iterator();
			while (userRoles.hasNext()) {
				this.groups.add(GWCGroup.build(userRoles.next()));
			}
		}
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public void save() {
		throw new RuntimeException("User.save() is not implemented yet");
		
	}
	public void addGroup(Group resource) {
		throw new RuntimeException("User.addGroup() is not implemented yet");
		
	}
}
