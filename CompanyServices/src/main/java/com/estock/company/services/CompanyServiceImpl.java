package com.estock.company.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.company.entities.Company;
import com.estock.company.exception.CompanyNotFoundException;
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
	public Map<String,String> fetchAllCompanyNames() {
		List<Company> companyList= companyDao.findAll();
		Map<String,String> nameMap=new HashMap<>();
		ListIterator<Company> namesIterator= companyList.listIterator();

    // Traversing elements
    while (namesIterator.hasNext()) {
       Company comp=namesIterator.next();
       nameMap.put(comp.getCompanyname(),comp.getCompanyCode());
    }
		return nameMap;
	}

	@Override
	public Company findCompanyByCompanyCode(String companyCode) {
		try {
			
			if(Optional.ofNullable(companyDao.findCompanyByCode(companyCode)).isEmpty()) {
				throw new CompanyNotFoundException("No Companies Found!!");
			}
		return companyDao.findCompanyByCode(companyCode);
		}
		catch(ConstraintViolationException ex){
		throw new ConstraintViolationException(ex.getMessage() + "manual " + ExceptionUtils.getRootCauseMessage(ex), ex.getSQLException(),
			    ex.getConstraintName());
		}
		
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
