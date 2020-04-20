package com.padrition.wordy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padrition.wordy.Word;
import com.padrition.wordy.entities.Result;
import com.padrition.wordy.entities.SearchWord;

@RestController
public class WordyRestController {

	@Autowired
	Word word;
	
	@PostMapping("/api/search")
	public @ResponseBody ResponseEntity<?> search(@ModelAttribute("search") SearchWord searchWord) throws IOException{
		Result result = new Result(word.getDefinitions(searchWord.getWord()));
		return ResponseEntity.ok(result);
	}
}
