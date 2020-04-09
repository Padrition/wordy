package com.padrition.wordy;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WordyApplication {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(WordyApplication.class, args);
		Word word = new Word();
		word.getMeaning("perhaps");
	}
}
