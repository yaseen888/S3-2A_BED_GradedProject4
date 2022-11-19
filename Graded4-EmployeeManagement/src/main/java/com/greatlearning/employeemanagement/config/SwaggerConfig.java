package com.greatlearning.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
	@Bean
	public Docket employeeapi() { 
		return new Docket(DocumentationType.SWAGGER_2) 
				.groupName("employee-api")
				.select()                                  
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.employeemanagement.controller"))                        
				.build();                                           
	}	

}