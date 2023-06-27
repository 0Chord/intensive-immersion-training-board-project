package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;

import lombok.Data;

@Data
public class CommentDto {
	private String nickname;
	private String comment;
	private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
	private Board board;
}
