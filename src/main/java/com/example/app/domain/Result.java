package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Result {
	
	
	private Integer result_id;
	
	@NotBlank
	private Integer user_id;
	
	@NotBlank
	private String derection;
	
	@NotNull
	private Integer rank;
	
	private Date time;
	
	@NotNull
	private Integer east_score;
	
	@NotNull
	private Integer south_score;
	
	@NotNull
	private Integer west_score;
	
	@NotNull
	private Integer north_score;
	
	@NotBlank
	private String east_player;
	
	@NotBlank
	private String south_player;
	
	@NotBlank
	private String west_player;
	
	@NotBlank
	private String north_player;
	
	
}
