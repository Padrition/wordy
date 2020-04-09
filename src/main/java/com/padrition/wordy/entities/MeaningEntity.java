package com.padrition.wordy.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeaningEntity {

	private String word;
	
	private String phonetic;
	
	private String origin;
	
	private Meaning meaning;
	
	public MeaningEntity() {}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPhonetic() {
		return phonetic;
	}

	public void setPhonetic(String phonetic) {
		this.phonetic = phonetic;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public Meaning getMeaning() {
		return this.meaning;
	}
	
	public void setMeaning(Meaning meaning) {
		this.meaning = meaning;
	}
}

