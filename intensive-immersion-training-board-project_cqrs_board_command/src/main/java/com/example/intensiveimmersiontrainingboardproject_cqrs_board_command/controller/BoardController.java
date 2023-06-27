package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.UpdateBoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/board")
public class BoardController {
	private final BoardService boardService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Validated BoardDto boardDto) {
		try {
			log.info(boardDto.getContent());
			log.info(boardDto.getTitle());
			boardService.save(boardDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.ok("SUCCESS");
	}

	@GetMapping("/delete-board/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("BoardController.delete");
		try {
			boardService.deleteBoard(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		return ResponseEntity.ok("SUCCESS");
	}

	@PostMapping("/update-board/{id}")
	public ResponseEntity<?> update(@RequestBody @Validated UpdateBoardDto updateBoardDto,@PathVariable Long id) {
		try {
			boardService.updateTitleAndContent(id, updateBoardDto.getTitle(),
				updateBoardDto.getContent());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		return ResponseEntity.ok("SUCCESS");

	}
}
