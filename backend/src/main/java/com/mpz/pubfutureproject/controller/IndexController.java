package com.mpz.pubfutureproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.services.ContasService;

@Controller
public class IndexController {
	
	@Autowired
	private ContasService service;
	
	@GetMapping
	public String getIndex(Model model) {
		//model.addAttribute("something", "this is coming form the controller!");
		
		List<Contas> list = service.findAll();
		model.addAttribute("contas", list);
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
}