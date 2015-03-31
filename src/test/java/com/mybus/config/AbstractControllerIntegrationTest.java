package com.mybus.config;

import static java.lang.String.format;
import lombok.Getter;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.mybus.SessionManager;
import com.mybus.dto.User;

@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = { CoreAppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractControllerIntegrationTest {

	private static final Logger logger = LoggerFactory.getLogger(AbstractControllerIntegrationTest.class);

	@Autowired
	@Getter
	private WebApplicationContext wac;

	public static MockHttpServletRequestBuilder asUser(final MockHttpServletRequestBuilder request, final User user) {
		if (logger.isTraceEnabled()) {
			logger.trace(format("Mocking request as user: %s", user));
		}
		return request.requestAttr(SessionManager.USER_SESSION_ATTR, user);
	}

	/*public static MockHttpServletRequestBuilder asUser(final MockHttpServletRequestBuilder request, final User user,
			final ScreenSession screenSession) {
		if (logger.isTraceEnabled()) {
			logger.trace(format("Mocking request as user: %s", user));
		}
		return request.requestAttr(SessionManager.USER_SESSION_ATTR, user).requestAttr(
				SessionManager.SCREEN_SESSION_ATTR, screenSession);
	}*/
}