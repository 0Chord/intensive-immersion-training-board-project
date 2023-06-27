package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Comment;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.CommentDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;

	@Override
	public void save(CommentDto commentDto) {
		Comment comment = Comment.builder()
			.nickname(commentDto.getNickname())
			.comment(commentDto.getComment())
			.createdDate(
				commentDto.getCreatedDate())
			.board(commentDto.getBoard())
			.build();
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> findAllByBoardId(Board board) {
		return commentRepository.findCommentsByBoard(board);
	}

	@Override
	@Transactional
	public void deleteComment(Long id) {
		commentRepository.deleteCommentById(id);
	}
}
