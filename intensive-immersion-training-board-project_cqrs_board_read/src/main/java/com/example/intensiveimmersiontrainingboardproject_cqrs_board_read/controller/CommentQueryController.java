package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service.CommentQueryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentQueryController {

	private final CommentQueryService commentQueryService;

	@GetMapping("/all/{id}")
	public ResponseEntity<?> findAll(@PathVariable("id") Long id) {
		List<Comment> comments = commentQueryService.findAllByBoardId(id);
		// log.info("comments = {}",comments);
		return ResponseEntity.ok(comments);
	}
}
