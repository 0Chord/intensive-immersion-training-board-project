package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto;

import lombok.Data;

@Data
public class UpdateBoardDto {
	private String content;
	private String title;
}
