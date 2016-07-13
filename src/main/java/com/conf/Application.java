package com.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com*")
@EnableContextCredentials(accessKey="${AWS_ACCESS}", secretKey="${AWS_KEY}")
@EnableContextRegion(autoDetect=true)
@EnableRdsInstance(databaseName="dev", dbInstanceIdentifier="nemerospg", username="${DB_USER_NAME}", password="${DB_PASSWORD}")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
}
