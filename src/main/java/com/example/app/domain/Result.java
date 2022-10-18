package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Result {

	private Integer resultId;

	private Integer userId;

	@NotBlank(message = "自家を選択してください")
	private String derection;

	private Integer rank;

	private Date time;

	@NotNull
	@Range(min=-999999, max=9999999)
	private Integer eastScore;

	@NotNull
	@Range(min=-999999, max=9999999)
	private Integer southScore;

	@NotNull
	@Range(min=-999999, max=9999999)
	private Integer westScore;

	@NotNull
	@Range(min=-999999, max=9999999)
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

	private String deplayer;

	private String ovscore;
}
