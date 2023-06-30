package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.CommentDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/comment")
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/{id}")
	public ResponseEntity<?> register(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) throws
		Exception {
		commentService.save(id, commentDto);

		return ResponseEntity.ok("SUCCESS");
	}

	@DeleteMapping("/delete-comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) throws Exception {
		commentService.deleteComment(id);
		return ResponseEntity.ok("SUCCESS");
	}

}
