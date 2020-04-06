package com.padrition.wordy;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padrition.wordy.entities.MeaningEntity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.Response;
import okhttp3.ResponseBody;

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

	public String getMeaning(String term) {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?"+
					"key=dict.1.1.20200406T111623Z.f814b4f9ba53b645.8bb93540ea96927b7e6c411a4b7f808b6501de19&"+
					"lang=en-en&text=" + term)
			.build();
		try {
			//dict.1.1.20200406T111623Z.f814b4f9ba53b645.8bb93540ea96927b7e6c411a4b7f808b6501de19  key
			//https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=APIkey&lang=en-en&text=time json request

			ObjectMapper mapper = new ObjectMapper();
			ResponseBody response = client.newCall(request).execute().body();
			MeaningEntity entity = mapper.readValue(response.string(), MeaningEntity.class);
			System.out.println(entity + "|"+entity.toString());
			System.out.println(response.string());
		}catch(IOException e){
			System.out.println(e);
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
