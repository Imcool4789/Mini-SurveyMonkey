package com.group5.MiniSurveyMonkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class MiniSurveyMonkeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniSurveyMonkeyApplication.class, args);
	}

}
