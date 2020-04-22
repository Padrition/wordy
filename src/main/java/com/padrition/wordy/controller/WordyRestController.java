package com.padrition.wordy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padrition.wordy.Word;
import com.padrition.wordy.entities.SearchWord;

@RestController
public class WordyRestController {

	@Autowired
	Word word;
	
	@GetMapping("/api/search/{term}")
	public @ResponseBody ResponseEntity<?> search(@PathVariable("term") String term) throws IOException{
		SearchWord searchWord = new SearchWord();
		searchWord.setWord(term);
		return ResponseEntity.ok(word.getDefinitions(term));
	}
}
