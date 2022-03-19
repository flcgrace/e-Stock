package com.estock.stock.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estock.stock.entity.StockPrice;

@Repository
public interface StockRepository extends JpaRepository<StockPrice, String> {
	@Query(value = "Select * from stock_price sp  where sp.company_code =?1 ", nativeQuery = true)
	public List<StockPrice> findByCompanyCode(String companyCode);
	
	@Query(value = "Select * from stock_price sp  where sp.company_code =?1 and sp.stock_date_time>=?2 and sp.stock_date_time<=?3 ", nativeQuery = true)
	public List<StockPrice> findByCompanyCodeAndTime(String companyCode, LocalDateTime start, LocalDateTime end);
	
}
