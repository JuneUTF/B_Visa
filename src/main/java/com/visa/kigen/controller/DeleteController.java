package com.visa.kigen.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.kigen.model.DeleteModel;
import com.visa.kigen.service.DeleteService;

@Controller
@RequestMapping
public class DeleteController {
	@Resource
	DeleteService deleteService;
@GetMapping("/delete")
public String delete() {
	return "redirect:/home";
}
@GetMapping("/delete/{id}")
public String deleteid(@PathVariable("id") int id,DeleteModel deleteModel,Model model ) {
	List<DeleteModel> user = deleteService.selectuser(deleteModel);
	if(user.toString()=="[]") {
		model.addAttribute("warning","情報がございません");
		model.addAttribute("showa","");
	}
	model.addAttribute("user",user);
return "delete";
}
@PostMapping("/delete/{id}")
public String postdelete(@PathVariable("id") int id,DeleteModel deleteModel, Model model){
	List<DeleteModel> user = deleteService.selectuser(deleteModel);
	String deleteName = "";
	for (DeleteModel e : user) {
		deleteName += e.getUsername();
	}
	int count = deleteService.delete(deleteModel);
	if(count == 1) {
		model.addAttribute("success",deleteName+"の情報が削除しました");
		model.addAttribute("showa","");
		return "delete";
	}else {
		model.addAttribute("warning","情報がございません");
		model.addAttribute("showa","");
		return "delete";
	}
}
}
