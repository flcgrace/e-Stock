package com.estock.company.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.estock.company.entities.Company;


public interface CompanyDao extends MongoRepository<Company, String> {
	
	@Query("{companyCode:'?0'}")
	Company findCompanyByCode(String companyCode);
	
	
//	@Query()
//	List<Company> findAll();
	Long deleteByCompanyCode(String companyCode);
	public long count();
	
}
