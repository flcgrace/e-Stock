package com.estock.stock.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stock.entity.StockPrice;
import com.estock.stock.services.StockServiceImpl;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockServiceImpl stockService;

	@PostMapping("/add/")
	public StockPrice addStockPrice(@RequestBody StockPrice stockPrice) {
		return stockService.saveStockPrice(stockPrice);
	}
	@GetMapping("/get/{companycode}/{startdate}/{enddate}")
	public List<StockPrice> getStockPrice(@PathVariable String companycode, @PathVariable String startdate, @PathVariable String enddate) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
		LocalDateTime start = LocalDateTime.parse(startdate, formatter);
		LocalDateTime end = LocalDateTime.parse(enddate, formatter);
		return stockService.fetchStockPrice(companycode, start, end);
	}
		
}