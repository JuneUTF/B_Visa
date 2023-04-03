package com.visa.kigen.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.kigen.model.UpdateModel;
import com.visa.kigen.service.DaySercive;
import com.visa.kigen.service.UpdateService;

@Controller
@RequestMapping
public class UpdateController {
@Resource
UpdateService updateSevice;

@GetMapping("/update")
public String showupdate() {
	return "redirect:/home";
}
@GetMapping("update/{id}")
public String Update(@PathVariable("id") int id,UpdateModel updateModel,Model model ) {
	List<UpdateModel> user = updateSevice.selectuser(updateModel);
	DaySercive nokori = new DaySercive();
	
	if(user.toString()=="[]") {
		model.addAttribute("warning","情報がありません。");
	}else {
		
		user.forEach(e -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	        LocalDate dater = LocalDate.parse(e.getVisa(), formatter);
	        String datenow = dater.toString();
	        e.setDaylocal(datenow);
			Long rem = nokori.remday(e.getVisa());
			String remnew = Long.toString(rem);
			if(rem>0) {
				remnew +="日";
			}else if (rem==0) {
				model.addAttribute("warning","本日に期限切れ");
				remnew ="本日に期限切れ";
			}else {
				remnew = remnew.substring(1);
				model.addAttribute("warning",remnew +"日前に期限切れ");
				remnew +="日前に期限切れ";
			}
				    e.setRemday(remnew);
				});
		
		model.addAttribute("user",user);
	};
	return "update";
};
@PostMapping("update/{id}")
public String PostUpdate(@PathVariable("id") int id,UpdateModel updateModel,Model model)throws ParseException {
	if(updateModel.getUsername() !="") {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(updateModel.getVisa());
        formatter.applyPattern("yyyy年MM月dd日");
        updateModel.setVisa(formatter.format(date));
	int count =  updateSevice.updateuser(updateModel);
	if(count ==1) {
		model.addAttribute("success","情報変更できました！");
	}else {
		model.addAttribute("warning","もう一度やり直してください");
	}
	}else {
		model.addAttribute("warning","もう一度やり直してください");
	}
	List<UpdateModel> user = updateSevice.selectuser(updateModel);
	DaySercive nokori = new DaySercive();
	user.forEach(e -> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate dater = LocalDate.parse(e.getVisa(), formatter);
        String datenow = dater.toString();
        e.setDaylocal(datenow);
		Long rem = nokori.remday(e.getVisa());
		String remnew = Long.toString(rem);
		if(rem>0) {
			remnew +="日";
		}else if (rem==0) {
			model.addAttribute("warning","本日に期限切れ");
			remnew ="本日に期限切れ";
		}else {
			remnew = remnew.substring(1);
			model.addAttribute("warning",remnew +"日前に期限切れ");
			remnew +="日前に期限切れ";
		}
			    e.setRemday(remnew);
			});
	model.addAttribute("user",user);
	return "update";
}
}
