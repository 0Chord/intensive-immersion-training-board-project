package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service;

import java.util.List;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Comment;

public interface CommentQueryService {
	List<Comment> findAllByBoardId(Long boardId);
}
