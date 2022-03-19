package com.estock.company.web;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.company.entities.Company;
import com.estock.company.services.CompanyServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyServiceImpl companyService;
	
	@PostMapping("/register")
	public Company registerCompany(@RequestBody Company company) {
		
		return companyService.saveCompany(company);
	}
	@GetMapping("/info/{companycode}")
	public Company getCompanyDetail(@PathVariable String companycode) {
		return companyService.findCompanyByCompanyCode(companycode);
	}
	
	@GetMapping("/getall")
	public List<Company> getListOfCompanies() {
		return companyService.fetchAllCompanies();
	}
	@DeleteMapping("/delete/{companycode}")
	public void deleteCompany(@PathVariable String companycode) {
		companyService.deleteCompany(companycode);
	
	}
	@GetMapping("/validate/{companycode}")
	public Boolean validateCompanyDetail(@PathVariable String companycode) {
		 Company company=companyService.findCompanyByCompanyCode(companycode);
		 if(!Objects.isNull(company)) {
			 return true;
		 }
		 return false;
	}

}
