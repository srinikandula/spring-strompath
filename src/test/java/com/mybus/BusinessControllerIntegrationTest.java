package com.mybus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import lombok.Getter;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mybus.dao.BusinessesDAO;
import com.mybus.model.Businesses;
public class BusinessControllerIntegrationTest extends AbstractControllerIntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	private BusinessesDAO businessDAO;

	@Getter
	private static String groupSeq1 = new ObjectId().toString();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(getWac()).build();
		// reset database state
		tearDown();
	}

	@After
	public void tearDown() {
		businessDAO.deleteAll();
	}

	@Test
	public void testFindBusinesses() {
		for(int i=0;i<5; i++){
			Businesses businesses = new Businesses();
			businesses.setName("testBusiness"+i);
			businessDAO.save(businesses);
		}
		 RequestBuilder request = get("/api/v1/businesses")
				 .param("name", "ABC");	
		 try {
			/*ResultActions actions = mockMvc.perform(request);
			actions.andExpect(status().isOk());
			actions.andExpect(content().contentType(ControllerUtils.JSON_UTF8));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

}
