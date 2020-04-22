package com.padrition.wordy;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padrition.wordy.entities.Adverb;
import com.padrition.wordy.entities.MeaningEntity;
import com.padrition.wordy.entities.Noun;
import com.padrition.wordy.entities.TransitiveVerb;
import com.padrition.wordy.entities.Verb;

@Component
public class Word {
	
	private static String dailyWord;
	
	@Scheduled(fixedRate = 86400000)
	public static void getNewWord() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://random-word-api.herokuapp.com/word?number=1", String.class);
		response = response.substring(2, response.length()-2);
		dailyWord = response;
	}

	public List<String> getDailyWordDefitions(String term)throws IOException{
		List<String> response = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		URL www = new URL("https://api.dictionaryapi.dev/api/v1/entries/en/"+term);
		MeaningEntity[] entMap = mapper.readValue(www, MeaningEntity[].class);
		for(MeaningEntity entity : entMap) {
			if(entity.getMeaning().getNoun() != null) {
				for(Noun noun : entity.getMeaning().getNoun()) {
					if(noun.getDefinition() != null){
						response.add("[noun]"+noun.getDefinition());
					}
				}
			}
			if(entity.getMeaning().getVerb() != null) {
				for(Verb verb : entity.getMeaning().getVerb()) {
					if(verb.getDefinition() != null){
						response.add("[verb]"+verb.getDefinition());
					}
				}
			}
			if(entity.getMeaning().getAdverb() != null) {
				for(Adverb adverb : entity.getMeaning().getAdverb()) {
					if(adverb.getDefinition() != null){
						response.add("[adverb]"+adverb.getDefinition());
					}
				}
			}
			if(entity.getMeaning().getTransitiveVerb() != null){
				for(TransitiveVerb transitiveVerb : entity.getMeaning().getTransitiveVerb()){
					if(transitiveVerb.getDefinition() != null){
						response.add("[transitive verb]"+transitiveVerb.getDefinition());
					}
				}
			}
		}
		return response;
	}

	public MeaningEntity getDefinitions(String term) throws IOException{
		MeaningEntity response = new MeaningEntity();
		ObjectMapper mapper = new ObjectMapper();
		URL www = new URL("https://api.dictionaryapi.dev/api/v1/entries/en/"+term);
		MeaningEntity[] entMap = mapper.readValue(www, MeaningEntity[].class);
		for(MeaningEntity entity : entMap){
			if(response.getWord()==null){
				response.setWord(entity.getWord());
			}
			if(response.getPhonetic()==null){
				response.setPhonetic(entity.getPhonetic());
			}
			if(response.getMeaning()==null){
				response.setMeaning(entity.getMeaning());
			}
		}
		return response;
	}
	
	public String getDailyWord() {
		return dailyWord;
	}

	public void setDailyWord(String word) {
		dailyWord = word;
	}
	
}
