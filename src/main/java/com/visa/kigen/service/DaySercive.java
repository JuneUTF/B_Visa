package com.visa.kigen.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class DaySercive {
	public long remday(String dateString){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date = LocalDate.parse(dateString, formatter);
        LocalDate now = LocalDate.now();
        long nowday = ChronoUnit.DAYS.between(now, date);
        return nowday;
    }
}
