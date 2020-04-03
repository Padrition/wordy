package com.padrition.wordy;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Word {
	
	public static String word;
	
	@Scheduled(fixedRate = 60000)
	public void getNewWord() {
		RestTemplate restTemplate = new RestTemplate();
		word = restTemplate.getForObject("https://random-word-api.herokuapp.com/word?number=1", String.class);
		System.out.println(word);
	}

	public static String getWord() {
		return word;
	}

	public static void setWord(String word) {
		Word.word = word;
	}
	
}
