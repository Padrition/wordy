package com.padrition.wordy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.padrition.wordy.Word;

@Controller
public class WordyController {
		
	@GetMapping("/")
	public String getHome(Model model) {
		String word = Word.getWord();
		model.addAttribute("word" , word);
		return "home";
	}
	
}
