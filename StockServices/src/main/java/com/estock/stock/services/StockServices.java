package com.estock.stock.services;

import java.time.LocalDateTime;
import java.util.List;

import com.estock.stock.entity.StockPrice;

public interface StockServices {
	public StockPrice saveStockPrice(StockPrice stockPrice);
	public List<StockPrice> fetchStockPrice(String companyCode);
	public List<StockPrice> fetchStockPrice(String companyCode, LocalDateTime start, LocalDateTime end);
}
