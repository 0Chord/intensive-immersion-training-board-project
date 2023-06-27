package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/comment")
public class CommentController {
	private final CommentService commentService;

	
}
