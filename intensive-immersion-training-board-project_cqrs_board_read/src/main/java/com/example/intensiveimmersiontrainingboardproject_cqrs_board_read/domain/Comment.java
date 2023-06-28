package com.example.intensiveimmersiontrainingboardproject_cqrs_board_read.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user")
	private String nickname;
	private String comment;
	private String password;
	@Column(name = "created_date")
	@CreatedDate
	private String createdDate;
	@Column(name = "modified_date")
	@LastModifiedDate
	private String modifiedDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
}
