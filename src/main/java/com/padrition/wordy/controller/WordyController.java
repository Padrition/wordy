package com.padrition.wordy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.padrition.wordy.Word;
import com.padrition.wordy.entities.SearchWord;

@Controller
public class WordyController {
	
	@Autowired
	Word word;
	
	@ModelAttribute
	public void addAttribute(Model model){
		try {
			String dailyWord = word.getDailyWord();
			if(word.getDailyWordDefitions(dailyWord).isEmpty()) {
				System.out.println(":::\tdefinition not found in com.padrition.wordy.controller.WordyController.addAttribute() ");
				Word.getNewWord();
				addAttribute(model);
			}else {
				model.addAttribute("dailyWord" , dailyWord);
				model.addAttribute("definition", word.getDailyWordDefitions(dailyWord));
			}
		}catch(IOException e) {
			System.out.println(":::\t"+e+ " occured in " + this.getClass());
			Word.getNewWord();
			addAttribute(model);
		}
	}
	
	@GetMapping("/")
	public String getHome(Model model){
		model.addAttribute("search", new SearchWord());
		return "home";
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("search") SearchWord searchWord , Model model) throws IOException{
		model.addAttribute("searchWordDefinition", word.getDefinitions(searchWord.getWord()));
		return "home";
	}
	
}