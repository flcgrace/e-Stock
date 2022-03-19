package com.estock.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.company.entities.Company;
import com.estock.company.repository.CompanyDao;

@Service
public class CompanyServiceImpl implements CompanyServices {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> fetchAllCompanies() {
		List<Company> companyList= companyDao.findAll();
		return companyList;
	}

	@Override
	public Company findCompanyByCompanyCode(String companyCode) {
		return companyDao.findCompanyByCode(companyCode);
		
	}

	@Override
	public Company saveCompany(Company company) {
		return companyDao.save(company);
		
	}

	@Override
	public void deleteCompany(String companyCode) {
		Long deletedcomp=companyDao.deleteByCompanyCode(companyCode);
	}

}
