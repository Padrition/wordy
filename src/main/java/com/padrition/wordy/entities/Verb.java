package com.padrition.wordy.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verb{
	
	private String definition;

	private String example;
	
	private List<String> synonyms;
	
	public Verb() {}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public List<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	@Override
	public String toString() {
		return "Verb [definition=" + definition + ", example=" + example + ", synonyms=" + synonyms + "]";
	}
	
}

