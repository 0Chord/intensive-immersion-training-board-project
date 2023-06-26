package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
	Optional<Board> findBoardById(Long id);
	List<Board> findAll();
}
