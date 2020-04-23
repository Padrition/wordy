package com.padrition.wordy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padrition.wordy.Word;

@RestController
public class WordyRestController {

	@Autowired
	Word word;
	
	@GetMapping("/api/search/{term}")
	public @ResponseBody ResponseEntity<?> search(@PathVariable("term") String term) throws IOException{
		return ResponseEntity.ok(word.getDefinitions(term));
	}
}
