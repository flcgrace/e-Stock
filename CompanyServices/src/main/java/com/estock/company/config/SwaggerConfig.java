package com.estock.company.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swagConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.estock.company.web"))
                .build()
               .apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
        return new ApiInfo("COMPANY SERVICES REST API",
                "Documentation for CompanyServices",
                "1.0",
                "Terms of service for using CompanyServices",
                new Contact("Felicia ","","2047154@gmail.com"),
                "",
                "",
                new ArrayList<>()
        );
    }
}
