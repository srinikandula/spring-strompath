package com.mybus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mybus.controller.utils.JSONPrefixTaintingPostProcessor;

@Configuration
@Import(CoreAppConfig.class)
public class TestConfig {

	  @Bean
	    public JSONPrefixTaintingPostProcessor jsonPrefixTaintingPostProcessor() {
	        return new JSONPrefixTaintingPostProcessor(false);
	    }

}