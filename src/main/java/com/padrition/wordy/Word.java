package com.padrition.wordy;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padrition.wordy.entities.MeaningEntity;

@Component
public class Word {
	
	public static String word;
	
	@Scheduled(fixedRate = 60000) // change to 24 hours length when done
	public void getNewWord() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://random-word-api.herokuapp.com/word?number=1", String.class);
		response = response.substring(2, response.length()-2);
		word = response;
	}
//https://dictionaryapi.com/api/v3/references/learners/json/test?key=6699457a-3204-49c5-85ed-d473b972968e
//https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20200406T111623Z.f814b4f9ba53b645.8bb93540ea96927b7e6c411a4b7f808b6501de19&lang=en-en&text=
	public String getMeaning(String term) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		URL www = new URL("https://api.dictionaryapi.dev/api/v1/entries/en/time");
		MeaningEntity[] empMap = mapper.readValue(www, MeaningEntity[].class);
		for(MeaningEntity entity : empMap) {
			System.out.println(entity.getWord());
		}
		return "";
	}
	
	public static String getWord() {
		return word;
	}

	public static void setWord(String word) {
		Word.word = word;
	}
	
}
