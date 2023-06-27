package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
	List<Comment> findCommentsByBoard(Board board);

	void deleteCommentById(Long id);
}
