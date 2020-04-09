package com.padrition.wordy.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meaning{
	
	private List<Noun> noun;
	
	private List<Verb> verb;
	
	public Meaning () {}

	public List<Noun> getNoun() {
		return noun;
	}

	public void setNoun(List<Noun> noun) {
		this.noun = noun;
	}

	public List<Verb> getVerb() {
		return verb;
	}

	public void setVerb(List<Verb> verb) {
		this.verb = verb;
	}
	
}
