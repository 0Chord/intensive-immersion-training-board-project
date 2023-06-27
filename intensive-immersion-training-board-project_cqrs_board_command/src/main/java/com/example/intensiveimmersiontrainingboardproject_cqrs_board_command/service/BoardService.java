package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.BoardDto;

public interface BoardService {
	void save(BoardDto boardDto) throws Exception;
	void deleteBoard(Long id) throws Exception;

	void updateTitleAndContent(Long id, String title,String content) throws Exception;
}
