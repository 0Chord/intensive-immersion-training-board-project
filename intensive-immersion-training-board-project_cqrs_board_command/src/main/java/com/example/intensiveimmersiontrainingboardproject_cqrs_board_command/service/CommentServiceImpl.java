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
	private final BoardService boardService;
	@Override
	public void save(Long id, CommentDto commentDto) throws Exception {
		Board board = boardService.findBoard(id).orElse(null);
		if(board == null){
			throw new Exception("게시글을 찾을 수 없습니다.");
		}
		Comment comment = Comment.builder()
			.nickname(commentDto.getNickname())
			.comment(commentDto.getComment())
			.createdDate(
				commentDto.getCreatedDate())
			.board(board)
			.build();
		commentRepository.save(comment);
	}

	@Override
	@Transactional
	public void deleteComment(Long id) throws Exception {
		try{
			commentRepository.deleteCommentById(id);
		}catch (Exception e){
			throw new Exception("댓글이 존재하지 않습니다.");
		}
	}
}
