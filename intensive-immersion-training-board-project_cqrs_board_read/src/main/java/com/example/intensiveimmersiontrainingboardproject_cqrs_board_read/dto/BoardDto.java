package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDto {
	private Long id;
	private String title;
	private String content;
	private String createdAt;
}
