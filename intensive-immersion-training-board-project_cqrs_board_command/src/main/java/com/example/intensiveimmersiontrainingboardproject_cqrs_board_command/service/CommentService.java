package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import java.util.List;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.CommentDto;

public interface CommentService {
	void save(Long id,CommentDto commentDto) throws Exception;


	void deleteComment(Long id) throws Exception;
}
