package com.padrition.wordy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class WordyController {	
	
	@GetMapping("/")
	public String getHome(Model model) {
		String word = "";
		String uri = "http://urban-word-of-the-day.herokuapp.com/today";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		model.addAttribute("word", result);
		return "home";
	}
	
}
