package com.estock.stock.services;

import java.time.LocalDateTime;
import java.util.List;

import com.estock.stock.entity.StockPrice;
import com.estock.stock.entity.StockPriceDisplay;

public interface StockServices {
	public StockPrice saveStockPrice(StockPrice stockPrice);
	public List<StockPrice> fetchStockPrice(String companyCode);
	public StockPriceDisplay fetchStockPrice(String companyCode, LocalDateTime start, LocalDateTime end);
	public void deleteByCompanyCode(String companyCode);
	public double getLatestStockPriceForCompany(String companyCode);
}
