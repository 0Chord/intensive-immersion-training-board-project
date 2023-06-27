package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class BoardDto {
	private String title;
	private String content;
	private String nickname;
	private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
}
