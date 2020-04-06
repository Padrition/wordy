package com.padrition.wordy.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class MeaningEntity {
	public String head;
	
	public MeaningEntity() {}

	public String getMean() {
		return head;
	}

	public void setMean(String mean) {
		this.head = mean;
	}

	@Override
	public String toString() {
		return "MeaningEntity [meaning=" + head + "]";
	}
	
	
}
