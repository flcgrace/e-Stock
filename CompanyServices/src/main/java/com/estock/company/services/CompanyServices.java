package com.estock.company.services;

import java.util.List;

import com.estock.company.entities.Company;

public interface CompanyServices {

	public List<Company> fetchAllCompanies();
	public Company findCompanyByCompanyCode(String companyCode);
	public Company saveCompany(Company company);
	public void deleteCompany(String companyCode);
}
