package com.estock.stock.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stock.entity.StockPrice;
import com.estock.stock.entity.StockPriceDisplay;
import com.estock.stock.exception.CompanyNotFoundException;
import com.estock.stock.services.StockServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockServiceImpl stockService;

	@PostMapping("/add/")
	public StockPrice addStockPrice(@RequestBody StockPrice stockPrice) {
		return stockService.saveStockPrice(stockPrice);
	}
	@DeleteMapping("/delete/{companycode}")
	public void deleteCompanyStocks(@PathVariable String companycode) {
		stockService.deleteByCompanyCode(companycode);;
	}
	@GetMapping("/latest/{companycode}")
	public String getLatestStockPrice(@PathVariable String companycode) {
//		Optional<Double> check = Optional.ofNullable(stockService.getLatestStockPriceForCompany(companycode));
//		if(check.isPresent()) {
//			return check.toString();
//		}
//		else {
//			throw new CompanyNotFoundException("Company Doesn't exist!!");
//		}
		Double value= stockService.getLatestStockPriceForCompany(companycode);
		if(value!=null) {
			return value.toString();
		}
		return "no stock";
		
	}
	@GetMapping("/get/{companycode}/{startdate}/{enddate}")
	public StockPriceDisplay getStockPrice(@PathVariable String companycode, @PathVariable String startdate, @PathVariable String enddate) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
		System.out.println("date time formatter "+DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println("startdate->"+startdate);
		System.out.println("enddate->"+enddate);
		LocalDateTime start = LocalDateTime.parse(startdate, formatter);
		LocalDateTime end = LocalDateTime.parse(enddate, formatter);
		System.out.println(""+start+end);
		return stockService.fetchStockPrice(companycode, start, end);
	}
		
}
