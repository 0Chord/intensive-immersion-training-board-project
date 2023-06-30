package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import java.util.Optional;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.PasswordDto;

public interface BoardService {
	void save(BoardDto boardDto) throws Exception;
	void deleteBoard(Long id, PasswordDto passwordDto) throws Exception;

	void updateTitleAndContent(Long id, String title,String content) throws Exception;

	Optional<Board> findBoard(Long id);
}
