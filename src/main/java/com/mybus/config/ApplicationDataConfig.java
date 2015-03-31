package com.mybus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;

@Configuration
@EnableWebMvc
@EnableScheduling
@Profile("default")
@ComponentScan(basePackages = "com.mybus")
@PropertySource(name = "mongoProperties", value = "classpath:mongo-config.properties")
@EnableMongoRepositories(basePackages = "com.mybus.dao")
public class ApplicationDataConfig extends AbstractApplicationDataConfig {

	private static final String HOME_DIR_PROPS_FILENAME = ".gwc.mongo.properties";
	private static final Logger logger = LoggerFactory.getLogger(ApplicationDataConfig.class);
	
    @Autowired
    private Environment mongoProperties;
    
    @Autowired 
    private CoreAppConfig config;
    

    @Bean
    @Override
    MongoSystemProperties getMongoSystemProperties() {
        return new MongoSystemProperties(mongoProperties, getHomeDirPropertiesFilename());
    }

    @Override
    String getHomeDirPropertiesFilename() {
        return HOME_DIR_PROPS_FILENAME;
    }
    
    @Bean(name ="stormpathClient")
    public Client getStormpathClient(){    	
    	Client client = Clients.builder()
    		     .setApiKey(ApiKeys.builder()
    		         .setId(config.props().getProperty("strompath.apiKey.id"))
    		         .setSecret(config.props().getProperty("strompath.apiKey.secret"))
    		         .build())
    		     .build();
    	return client;
    }
    
   /* @Bean(name ="stormpathClient")
    public MethodInvokingFactoryBean getStormpathClient(){
    	MethodInvokingFactoryBean invokeBean = new MethodInvokingFactoryBean();
    	invokeBean.setTargetObject(getStormpathClientBuilder());
    	invokeBean.setTargetMethod("build");
    	return invokeBean;
    }*/
   

   
}
