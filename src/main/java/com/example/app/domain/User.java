package com.example.app.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	
	@NotBlank
	@Size(max=20)
	private String login_id;
	
	@NotBlank
	private String login_pass;
	
	private String confpass;
}