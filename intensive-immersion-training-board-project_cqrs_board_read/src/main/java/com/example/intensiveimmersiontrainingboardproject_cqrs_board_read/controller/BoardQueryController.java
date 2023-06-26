package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service.BoardQueryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/query/board")
public class BoardQueryController {

	private final BoardQueryService boardQueryService;

	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchBoard(@PathVariable Long id) {
		try {
			BoardDto boardDto = boardQueryService.findBoardById(id);
			return ResponseEntity.ok(boardDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/search-boards")
	public ResponseEntity<?> searchBoards() {
		List<Board> boards = boardQueryService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(boards);
	}
}
