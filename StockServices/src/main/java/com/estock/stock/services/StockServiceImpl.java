package com.estock.stock.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estock.stock.entity.StockPrice;
import com.estock.stock.entity.StockPriceDisplay;
import com.estock.stock.entity.StockStat;
import com.estock.stock.exception.CompanyNotFoundException;
import com.estock.stock.repository.StockRepository;

@Service
public class StockServiceImpl implements StockServices{
	@Autowired
	StockRepository stockRepo;

	@Override
	public StockPrice saveStockPrice(StockPrice stockPrice) {
		System.out.println(stockPrice.getCompanyCode());
		final String uri = "http://localhost:8081/company/validate/"+stockPrice.getCompanyCode();

	    RestTemplate restTemplate = new RestTemplate();
	    Boolean result = restTemplate.getForObject(uri, Boolean.class);

	    if(result) {
	    stockPrice.setDateTime(LocalDateTime.now());
		return stockRepo.save(stockPrice);
	    }
	    return null;
	}


	@Override
	public List<StockPrice> fetchStockPrice(String companyCode) {
		return stockRepo.findByCompanyCode(companyCode);
	}

	@Override
	public StockPriceDisplay fetchStockPrice(String companyCode, LocalDateTime start, LocalDateTime end) {
		
		 List<StockPrice> stocks=stockRepo.findByCompanyCodeAndTime(companyCode, start, end);
		 StockStat obj=stockRepo.getMaxStockPrice(companyCode, start, end);
		 StockPriceDisplay disp= new StockPriceDisplay(stocks, obj.getMaxstock(),obj.getMinstock(),obj.getAvgstock());
		 return disp;
	}
	
	@Override
	@Transactional
	public void deleteByCompanyCode(String companyCode) {
		stockRepo.deleteByCompanyCode(companyCode);
	}

	@Override
	public double getLatestStockPriceForCompany(String companycode) {
		Optional<Double> check = Optional.ofNullable(stockRepo.getLatestStockPrice(companycode));
		if(check.isPresent()) {
			return  stockRepo.getLatestStockPrice(companycode);
		}
		else {
			throw new CompanyNotFoundException("Company Doesn't exist!!");
		}
		//return stockRepo.getLatestStockPrice(companycode);
	}

}
