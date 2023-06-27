package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import java.util.List;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.CommentDto;

public interface CommentService {
	void save(CommentDto commentDto);

	List<Comment> findAllByBoardId(Board board);

	void deleteComment(Long id);
}
