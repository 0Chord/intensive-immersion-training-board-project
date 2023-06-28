package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService {

	private final CommentRepository commentRepository;

	@Override
	public List<Comment> findAllByBoardId(Long boardId) {
		return commentRepository.findCommentsByBoardId(boardId);
	}
}
