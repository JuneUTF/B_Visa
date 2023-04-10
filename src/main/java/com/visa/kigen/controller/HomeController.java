package com.visa.kigen.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.kigen.model.HomeModel;
import com.visa.kigen.service.DaySercive;
import com.visa.kigen.service.HomeService;

@Controller
@RequestMapping
public class HomeController {
	@Resource
	HomeService homeService;
	@GetMapping("/")
	public String index() {
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String home(Model model,HomeModel homeModel) {
		List<HomeModel> list = homeService.selectAll(homeModel);
		DaySercive nokori = new DaySercive();
		
		list.forEach(e -> {
			  
			Long remday = nokori.remday(e.getVisa());
//			LONG型　To　INT　型　とマイナス消し
    		int rem = (int) Math.abs(remday);
//    		JavaのPeriod　読み込
    		 LocalDate today = LocalDate.now();
    	     LocalDate futureDate = today.plusDays(rem);
    		Period period = Period.between(today, futureDate);
//    		何年計算
    		int years = period.getYears();
//    		何月計算
    		int months = period.getMonths();
//    		何日計算
    		int days = period.getDays();
//    		チェック
			String remnew = "";
			 if (years >0) {
				 remnew +=(years+"年");
				e.setColor(2);
			}
			 if(months >0){
				 remnew +=(months+"月");
				e.setColor(2);
			} if (days>0) {
				remnew +=(days+"日");
				e.setColor(2);
			}else if (days==0){
				remnew +="本日に期限切れ";
				e.setColor(1);
			}
			if(remday<0) {
				remnew +="前に期限切れ";
				e.setColor(0);
			}
				    e.setRemday(remnew);
				});
		
		model.addAttribute("user",list);
		return "home";
	}
	@GetMapping("/homeAZ")
	public String homeAZ(Model model,HomeModel homeModel) {
		List<HomeModel> list = homeService.selectAllAZ(homeModel);
		DaySercive nokori = new DaySercive();
		
		list.forEach(e -> {
			  
			Long remday = nokori.remday(e.getVisa());
//			LONG型　To　INT　型　とマイナス消し
    		int rem = (int) Math.abs(remday);
//    		JavaのPeriod　読み込
    		 LocalDate today = LocalDate.now();
    	     LocalDate futureDate = today.plusDays(rem);
    		Period period = Period.between(today, futureDate);
//    		何年計算
    		int years = period.getYears();
//    		何月計算
    		int months = period.getMonths();
//    		何日計算
    		int days = period.getDays();
//    		チェック
			String remnew = "";
			 if (years >0) {
				 remnew +=(years+"年");
				e.setColor(2);
			}
			 if(months >0){
				 remnew +=(months+"月");
				e.setColor(2);
			} if (days>0) {
				remnew +=(days+"日");
				e.setColor(2);
			}else if (days==0){
				remnew +="本日に期限切れ";
				e.setColor(1);
			}
			if(remday<0) {
				remnew +="前に期限切れ";
				e.setColor(0);
			}
				    e.setRemday(remnew);
				});
		
		model.addAttribute("user",list);
		return "home";
	}
	@GetMapping("/search")
	 public String search(Model model, HomeModel homeModel) {
		List<HomeModel> list = new ArrayList<>();
		if(homeModel.getSearch().equals("id")) {
			try {
				int newid;
				newid = Integer.parseInt(homeModel.getSearchkey());
			    homeModel.setSearchid(newid);
				list.addAll(homeService.searchid(homeModel));
			} catch (NumberFormatException e) {
				model.addAttribute("warning","番号として入力してください。");
			}
		}else {
			homeModel.setSearchuser(homeModel.getSearchkey());
			list.addAll(homeService.searchuser(homeModel));
		}
		
		DaySercive nokori = new DaySercive();
		list.forEach(e -> {
			Long rem = nokori.remday(e.getVisa());
			String remnew = Long.toString(rem);
			if(rem>0) {
				remnew +="日";
				e.setColor(2);
			}else if (rem==0) {
				remnew ="本日に期限切れ";
				e.setColor(1);
			}else {
				remnew = remnew.substring(1);
				remnew +="日前に期限切れ";
				e.setColor(0);
			}
				    e.setRemday(remnew);
				});

		model.addAttribute("user",list);
		return "home";
	}
	
//	get visa a-z
	@GetMapping("/visaAZ")
	public String visaAZ(Model model,HomeModel homeModel) {
		List<HomeModel> list = homeService.selectAllDaysAZ(homeModel);
		DaySercive nokori = new DaySercive();
		
		list.forEach(e -> {
			  
			Long remday = nokori.remday(e.getVisa());
//			LONG型　To　INT　型　とマイナス消し
    		int rem = (int) Math.abs(remday);
//    		JavaのPeriod　読み込
    		 LocalDate today = LocalDate.now();
    	     LocalDate futureDate = today.plusDays(rem);
    		Period period = Period.between(today, futureDate);
//    		何年計算
    		int years = period.getYears();
//    		何月計算
    		int months = period.getMonths();
//    		何日計算
    		int days = period.getDays();
//    		チェック
			String remnew = "";
			 if (years >0) {
				 remnew +=(years+"年");
				e.setColor(2);
			}
			 if(months >0){
				 remnew +=(months+"月");
				e.setColor(2);
			} if (days>0) {
				remnew +=(days+"日");
				e.setColor(2);
			}else if (days==0){
				remnew +="本日に期限切れ";
				e.setColor(1);
			}
			if(remday<0) {
				remnew +="前に期限切れ";
				e.setColor(0);
			}
				    e.setRemday(remnew);
				});
		
		model.addAttribute("user",list);
		return "home";
	}
	
//	get visa z-a
	@GetMapping("/visaZA")
	public String visaZA(Model model,HomeModel homeModel) {
		List<HomeModel> list = homeService.selectAllDaysZA(homeModel);
		DaySercive nokori = new DaySercive();
		
		list.forEach(e -> {
			  
			Long remday = nokori.remday(e.getVisa());
//			LONG型　To　INT　型　とマイナス消し
    		int rem = (int) Math.abs(remday);
//    		JavaのPeriod　読み込
    		 LocalDate today = LocalDate.now();
    	     LocalDate futureDate = today.plusDays(rem);
    		Period period = Period.between(today, futureDate);
//    		何年計算
    		int years = period.getYears();
//    		何月計算
    		int months = period.getMonths();
//    		何日計算
    		int days = period.getDays();
//    		チェック
			String remnew = "";
			 if (years >0) {
				 remnew +=(years+"年");
				e.setColor(2);
			}
			 if(months >0){
				 remnew +=(months+"月");
				e.setColor(2);
			} if (days>0) {
				remnew +=(days+"日");
				e.setColor(2);
			}else if (days==0){
				remnew +="本日に期限切れ";
				e.setColor(1);
			}
			if(remday<0) {
				remnew +="前に期限切れ";
				e.setColor(0);
			}
				    e.setRemday(remnew);
				});
		
		model.addAttribute("user",list);
		return "home";
	}
}
