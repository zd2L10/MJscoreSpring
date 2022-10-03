package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Result {

	private Integer resultId;

	
	private Integer userId;

	@NotBlank(message = "自家を選択してください")
	private String derection;

	@NotNull
	private Integer rank;

	private Date time;

	@NotNull(message = "東家の点数を入力してください")
	@Max(7)
	private Integer eastScore;

	@NotNull(message = "南家の点数を入力してください")
	@Max(7)
	private Integer southScore;

	@NotNull(message = "西家の点数を入力してください")
	@Max(7)
	private Integer westScore;

	@NotNull(message = "北家の点数を入力してください")
	@Max(7)
	private Integer northScore;

	@NotBlank
	@Size(max = 20)
	private String eastPlayer;

	@NotBlank
	@Size(max = 20)
	private String southPlayer;

	@NotBlank
	@Size(max = 20)
	private String westPlayer;

	@NotBlank
	@Size(max = 20)
	private String northPlayer;

	private User user;
}
