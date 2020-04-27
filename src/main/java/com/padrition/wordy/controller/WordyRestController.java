package com.padrition.wordy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padrition.wordy.Word;
import com.padrition.wordy.entities.MeaningEntity;

@RestController
public class WordyRestController {

	@Autowired
	Word word;
	
	@GetMapping("/api/search/{term}")
	public @ResponseBody ResponseEntity<?> search(@PathVariable("term") String term) throws IOException{
		MeaningEntity meaningEntity = new MeaningEntity();
		meaningEntity = word.getDefinitions(term);
		if(meaningEntity.getMeaning() == null){
			return ResponseEntity.ok(null);
		}else{
			return ResponseEntity.ok(meaningEntity);
		}
	}
}
