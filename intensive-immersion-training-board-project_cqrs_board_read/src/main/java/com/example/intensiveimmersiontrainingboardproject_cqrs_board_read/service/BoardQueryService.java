package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service;

import java.util.List;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.dto.BoardDto;

public interface BoardQueryService {
	BoardDto findBoardById(Long id) throws Exception;
	List<Board> findAll();
}
