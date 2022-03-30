package com.estock.stock.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estock.stock.entity.StockPrice;
import com.estock.stock.entity.StockStat;

@Repository
public interface StockRepository extends JpaRepository<StockPrice, String> {
	@Query(value = "Select * from stock_price sp  where sp.company_code =?1 ", nativeQuery = true)
	public List<StockPrice> findByCompanyCode(String companyCode);
	
	@Query(value = "Select * from stockservice.stock_price sp  where sp.company_code =?1 and sp.stock_date_time>=?2 and sp.stock_date_time<=?3 ", nativeQuery = true)
	public List<StockPrice> findByCompanyCodeAndTime(String companyCode, LocalDateTime start, LocalDateTime end);
	
	@Query(value="select price from stockservice.stock_price sp2 where company_code = ?1 and stock_date_time in (select max(stock_date_time)  from stockservice.stock_price sp where company_code = ?1)",nativeQuery= true)
	public Double getLatestStockPrice(String companycode);
	
	@Modifying
	@Query(value="Delete from stockservice.stock_price sp where sp.company_code=?1",nativeQuery=true)
	void deleteByCompanyCode(String companyCode);
	
	@Query(value="Select min(price) as minstock, max(price) as maxstock , avg(price) as avgstock from stockservice.stock_price sp where sp.company_code =?1 and sp.stock_date_time>=?2 and sp.stock_date_time<=?3",nativeQuery=true)
	public StockStat getMaxStockPrice(String companycode, LocalDateTime start, LocalDateTime end);
	
}
