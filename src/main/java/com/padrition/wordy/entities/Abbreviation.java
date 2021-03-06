package com.padrition.wordy.entities;

import java.util.List;

public class Abbreviation {
    private String definition;

	private String example;
	
    private List<String> synonyms;
    
    public Abbreviation(){}

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
        return "Abbreviation [definition=" + definition + ", example=" + example + ", synonyms=" + synonyms + "]";
    }

    
}
