package com.valuelabs.configuration;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = {"com.valuelabs"})
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	 
	@Bean
	 public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
	    	  .apiInfo(getApiInfo())	  
	    	  .select()
		  .apis(RequestHandlerSelectors.basePackage("com.valuelabs"))
		  .paths(PathSelectors.any())
		  .build();
	   }
	   private ApiInfo getApiInfo() {
	      return new ApiInfo("REST Api Documentation",
		  "REST Api Documentation", 
		  "2.0", 
		  "urn:tos",
		   new Contact("Srujana Medagam", "https://www.valuelabs.com/", "SRUJANA.MEDAGAM@VALUELABS.COM"), 
		  "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
		   new ArrayList<VendorExtension>());
	   }
}