package com.visa.kigen.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.visa.kigen.model.RegressionModel;
import com.visa.kigen.service.RegressionService;
@Controller
@RequestMapping
public class RegressionController {
	@Resource
	RegressionService regressionService;
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/register")
	public String postregister(Model model,RegressionModel regressionModel,RedirectAttributes attributes) throws ParseException {
		String user = regressionModel.getUsername().trim().toString();
		Pattern pattern = Pattern.compile("[\\d]"); 
        Matcher matcher = pattern.matcher(user);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(regressionModel.getVisa());
        formatter.applyPattern("yyyy年MM月dd日");
        regressionModel.setVisa(formatter.format(date));
		if(user!="" && !matcher.find()) {
			int count =regressionService.insert(regressionModel);
			if(count==1) {
				
				attributes.addFlashAttribute("success","情報を登録できました！");
				return "redirect:update/"+regressionModel.getId();
				
			}else {
				model.addAttribute("warning","もう一度やり直してください");
				return "register";
			}
		}else {
			model.addAttribute("warning","名前を正しく入力してください");
			return "register";
		}
		
		
	}
}
