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
		String response = restTemplate.getForObject("https://random-word-api.herokuapp.com/word?number=1", String.class);
		response = response.substring(2, response.length()-2);
		word = response;
		System.out.println(response);
	}

	public static String getWord() {
		return word;
	}

	public static void setWord(String word) {
		Word.word = word;
	}
	
}
