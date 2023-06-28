package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
	List<Comment> findCommentsByBoardId(Long id);
}
