package com.estock.stock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        String caseStartDate = dateFormat.format(LocalDateTime.now());
//        System.out.println(LocalDateTime.now());
//        LocalDateTime localdatetime = LocalDateTime.parse(caseStartDate, dateFormat);
//        System.out.println(localdatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
		LocalDateTime start = LocalDateTime.parse("2022-03-22T12:49", formatter);
		System.out.println("  "+start);
	}

}
