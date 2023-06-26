package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardQueryServiceImpl implements BoardQueryService {

	private final BoardRepository boardRepository;

	@Override
	public BoardDto findBoardById(Long id) throws Exception {
		Optional<Board> optBoard = boardRepository.findBoardById(id);
		Board board = optBoard.orElse(null);
		if (board != null) {
			BoardDto boardDto = BoardDto.builder()
				.id(board.getId())
				.content(board.getContent())
				.title(board.getTitle())
				.build();
			return boardDto;
		}
		throw new Exception("게시글이 존재하지 않습니다.");
	}

	@Override
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
}
