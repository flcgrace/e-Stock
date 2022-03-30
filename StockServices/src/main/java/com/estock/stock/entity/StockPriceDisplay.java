package com.estock.stock.entity;

import java.util.List;

public class StockPriceDisplay {
	
	private List<StockPrice> stock;
	private double maxStock;
	private double minStock;
	private double avgStock;
	public StockPriceDisplay(List<StockPrice> stock, double maxStock, double minStock, double avgStock) {
		super();
		this.stock = stock;
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.avgStock = avgStock;
	}
	public List<StockPrice> getStock() {
		return stock;
	}
	public void setStock(List<StockPrice> stock) {
		this.stock = stock;
	}
	public double getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(double maxStock) {
		this.maxStock = maxStock;
	}
	public double getMinStock() {
		return minStock;
	}
	public void setMinStock(double minStock) {
		this.minStock = minStock;
	}
	public double getAvgStock() {
		return avgStock;
	}
	public void setAvgStock(double avgStock) {
		this.avgStock = avgStock;
	}

}
