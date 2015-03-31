/*
 * Copyright 2012 Stormpath, Inc. and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mybus.security.model.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mybus.config.CoreAppConfig;
import com.mybus.dto.User;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountList;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.directory.CustomData;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.ds.DataStore;
import com.stormpath.sdk.tenant.Tenant;

/**
 * @author Elder Crisostomo
 */
@Service
public class DefaultStormpathService implements StormpathService {

	@Resource(name = "stormpathClient")
	private Client client;

	@Autowired
	private CoreAppConfig appConfig;
	
	private DataStore dataStore;

	private Directory directory;

	private Application application;

	private Tenant tenant;

	@Value("${stormpath.sdk.getwell.rest.url}")
	private String getwellApplicationURL;

	@Value("${stormpath.sdk.administrator.rest.url}")
	private String administratorGroupURL;

	@Value("${stormpath.sdk.premium.rest.url}")
	private String premiumGroupURL;

	@Value("${stormpath.sdk.getwell.directory.rest.url}")
	private String directoryURL;

	@Override
	public String getDirectoryURL() {
		return getURLProperty("stormpath.sdk.getwell.directory.rest.url");
	}

	@Override
	public String getAdministratorGroupURL() {
		return getURLProperty("stormpath.sdk.administrator.rest.url");
	}

	@Override
	public Application getApplication() {
		if (application == null) {
			application = getDataStore().getResource(getGetwellApplicationURL(), Application.class);
		}
		return application;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public String getGetwellApplicationURL() {
		return getURLProperty("stormpath.sdk.getwell.rest.url");
	}

	@Override
	public DataStore getDataStore() {
		if (dataStore == null) {
			dataStore = getClient().getDataStore();
		}
		return dataStore;
	}

	@Override
	public Tenant getTenant() {
		if (tenant == null) {
			tenant = getClient().getCurrentTenant();
		}
		return tenant;
	}

	@Override
	public Directory getDirectory() {
		if (directory == null) {
			directory = getDataStore().getResource(getDirectoryURL(), Directory.class);
		}
		return directory;
	}

	private String getURLProperty(String propertyName) {
		String thePath = appConfig.props().getProperty(propertyName);
		/*
		 * try { thePath = URLEncoder.encode(thePath, "UTF-8"); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return thePath;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		for (Account account : getApplication().getAccounts()) {
			users.add(new User(account));
		}
		return users;
	}

	@Override
	public User getUserByEmail(final String email) {
		User user = null;
		Account account = getAccountByEmail(email);
		if (account != null){
			user = new User(account);
		}
		return user;
	}

	private Account getAccountByEmail(String email) {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("email", email);
		AccountList accountList = getApplication().getAccounts(queryParams);
		if (accountList.iterator().hasNext()) {
			return accountList.iterator().next();
		}
		return null;
	}

	@Override
	public boolean updateAccountData(String email, Map<String, Object> accountData) {
		Account account = getAccountByEmail(email);
		CustomData customData = account.getCustomData();
		for (Map.Entry<String, Object> data : accountData.entrySet()) {
			customData.put(data.getKey(), data.getValue());	
		}
		customData.save();
		return true;
	}
}
