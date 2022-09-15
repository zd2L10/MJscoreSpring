package com.example.app.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	
	@NotBlank
	private String login_id;
	
	@NotBlank
	private String login_pass;
	
	
}