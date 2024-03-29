package com.estock.company.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Document("Company")
@Validated
public class Company {	
	@Id
	@GeneratedValue
    private String id;
	@Indexed(name = "company_code_uniq",unique = true)
	@NotNull(message = "Company Code cannot be empty")
	private String companyCode;
	@NotNull(message = "Company Name cannot be empty")
    private String companyName;
	@NotNull(message = "Company CEO cannot be empty")
    private String companyCEO;
	@NotNull(message = "Company Website cannot be empty")
    private String companyWebsite;
	@NotNull(message = "Company Turnover cannot be empty")
	@Min(10)
    private int companyTurnover;
	@NotNull(message = "Company Stock Exchange cannot be empty")
    private String stockExchange;
	public Company() {};
	public Company(String id, String companyCode, String companyName, String companyCEO, String companyWebsite,
			int companyTurnover, String stockExchange) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyWebsite = companyWebsite;
		this.companyTurnover = companyTurnover;
		this.stockExchange = stockExchange;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyname() {
		return companyName;
	}
	public void setCompanyname(String companyname) {
		this.companyName = companyname;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public int getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(int companyTurnover) {
		this.companyTurnover = companyTurnover;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
    
    
}
