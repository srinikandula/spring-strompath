package com.mybus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mybus.config.AbstractDAOIntegrationTest;
import com.mybus.dto.User;
import com.mybus.security.model.sdk.StormpathService;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.AuthenticationResult;
import com.stormpath.sdk.authc.UsernamePasswordRequest;
import com.stormpath.sdk.directory.CustomData;

public class StrompathIntegrationTest extends AbstractDAOIntegrationTest {

	@Autowired
	private StormpathService strompath;

	@Before
	public void setup() {
		purgeAllData();
	}

	@After
	public void tearDown() {
		purgeAllData();
	}

	private void purgeAllData() {
		
	}

	@Test
	public void testLogin(){
		 AuthenticationRequest request = new UsernamePasswordRequest("suresh@getwellcities.com", "1234qwer");
         AuthenticationResult authcResult = strompath.getApplication().authenticateAccount(request);
         Account account = authcResult.getAccount();
         Assert.assertNotNull(account);
         Assert.assertEquals("suresh@getwellcities.com", account.getUsername());
	}
	
	@Test
	public void saveUserCustomData(){
		 AuthenticationRequest request = new UsernamePasswordRequest("suresh@getwellcities.com", "1234qwer");
         AuthenticationResult authcResult = strompath.getApplication().authenticateAccount(request);
         Account account = authcResult.getAccount();
         CustomData customData = account.getCustomData();
         customData.put("test", "testdata");
         List<String> businessIds = new ArrayList<String>();
         businessIds.add("1234");
         businessIds.add("333345");
         customData.put("businessIds", businessIds);
         customData.save();
         customData = account.getCustomData();
         Assert.assertEquals("testdata", customData.get("test").toString());
         Assert.assertTrue(customData.get("businessIds") instanceof List);
         customData.remove("test");
         customData.remove("businessIds");
         customData.save();
         customData = account.getCustomData();
         Assert.assertNull(customData.get("test"));
         Assert.assertNull(customData.get("businessIds"));
         
     }
	
	@Test
	public void testFindAccount(){

		 AuthenticationRequest request = new UsernamePasswordRequest("suresh@getwellcities.com", "1234qwer");
         AuthenticationResult authcResult = strompath.getApplication().authenticateAccount(request);
         Account account = authcResult.getAccount();
         CustomData customData = account.getCustomData();         
         customData.put("test", "testdata");
         List<String> businessIds = new ArrayList<String>();
         businessIds.add("1234");
         businessIds.add("333345");
         customData.put("businessIds", businessIds);
         customData.save();
         
         User user = strompath.getUserByEmail("suresh@getwellcities.com");
         CustomData userCustomData = user.getCustomData();         
         Assert.assertEquals("testdata", userCustomData.get("test").toString());
         Assert.assertTrue(userCustomData.get("businessIds") instanceof List);
         
         customData.remove("test");
         customData.remove("businessIds");
         customData.save();
         userCustomData = account.getCustomData();
         Assert.assertNull(userCustomData.get("test"));
         Assert.assertNull(userCustomData.get("businessIds"));

	}

	@Test
	public void testUpdateAccountData(){

		 AuthenticationRequest request = new UsernamePasswordRequest("suresh@getwellcities.com", "1234qwer");
         AuthenticationResult authcResult = strompath.getApplication().authenticateAccount(request);
         Account account = authcResult.getAccount();         
         CustomData customData = account.getCustomData();  
         
         // Adding custom data 
         customData.put("test", "testdata");
         List<String> businessIds = new ArrayList<String>();
         businessIds.add("1234");
         businessIds.add("5678");
         customData.put("businessIds", businessIds);
         customData.save();

         // Verifying custom data
         User user = strompath.getUserByEmail("suresh@getwellcities.com");
         CustomData userCustomData = user.getCustomData();         
         Assert.assertEquals("testdata", userCustomData.get("test").toString());
         Assert.assertTrue(userCustomData.get("businessIds") instanceof List);

         // New custom data for update
         Map<String, Object> customData4Update = new HashMap<String, Object>();
         customData4Update.put("test", "testDataUpdated");
         List<String> businessIds4Update = new ArrayList<String>();
         businessIds4Update.add("4321");
         businessIds4Update.add("8765");
         businessIds4Update.add("9999");
         customData4Update.put("businessIds", businessIds4Update);
         
         // Updating the custom data
         boolean updated = strompath.updateAccountData("suresh@getwellcities.com", customData4Update);
         
         
         // Verifying updated custom data
         user = strompath.getUserByEmail("suresh@getwellcities.com");
         userCustomData = user.getCustomData();         
         Assert.assertTrue(updated);
         Assert.assertEquals("testDataUpdated", userCustomData.get("test").toString());
         Assert.assertTrue(userCustomData.get("businessIds") instanceof List);
         Assert.assertEquals(3, ((List)userCustomData.get("businessIds")).size());
         
         customData.remove("test");
         customData.remove("businessIds");
         customData.save();
         userCustomData = account.getCustomData();
         Assert.assertNull(userCustomData.get("test"));
         Assert.assertNull(userCustomData.get("businessIds"));

	}

}

