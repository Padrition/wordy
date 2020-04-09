package com.padrition.wordy.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.padrition.wordy.Word;

@Controller
public class WordyController {
	
	Word word = new Word();
	
	@GetMapping("/")
	public String getHome(Model model) throws IOException {
		String dailyWord = Word.getWord();
		model.addAttribute("dailyWord" , dailyWord);
		model.addAttribute("definition", word.getDefinition(dailyWord));
		System.out.println("::dailyWord - " + dailyWord);
		System.out.println("::full definition - " + word.getDefinition(dailyWord));
		return "home";
	}
	
}
