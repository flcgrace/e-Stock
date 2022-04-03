package com.estock.restclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	 
		private String id;
		
		private String companyCode;
		
	    private String companyName;
		
	    private String companyCEO;
		
	    private String companyWebsite;
				
	    private int companyTurnover;
		
	    private String stockExchange;

}
