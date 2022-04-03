package com.estock.restclient;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.estock.restclient.models.Company;

@SpringBootApplication
public class RestClientApplication {
	
	String companyServiceUrl="http://localhost:8081/company/getall";
	String stockServiceUrl="";
	
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}
	
	@Bean
	public List<Company> findCompanies() {
		HttpHeaders httpHeader=new HttpHeaders();
		httpHeader.add("header1", "value1");
		httpHeader.add("header2", "value2");
		
		HttpEntity<Company> httpEntity= new HttpEntity<Company>(null,httpHeader);
		ResponseEntity<List<Company>> res = restTemplate.exchange(companyServiceUrl,
				HttpMethod.GET,
				httpEntity,
				new ParameterizedTypeReference <List<Company>>() {});
		System.out.println("Response Status :: "+res.getStatusCodeValue());
		System.out.println("Response Body :: "+res.getBody());
		return res.getBody();
	}
	
	@Bean
	public Supplier<List<Company>> findComp(){
		return () -> findCompanies();
	}

}
