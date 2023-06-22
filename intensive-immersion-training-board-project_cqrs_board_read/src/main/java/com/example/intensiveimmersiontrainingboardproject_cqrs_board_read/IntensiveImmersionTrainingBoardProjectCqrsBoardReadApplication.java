package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IntensiveImmersionTrainingBoardProjectCqrsBoardReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntensiveImmersionTrainingBoardProjectCqrsBoardReadApplication.class, args);
	}

}
