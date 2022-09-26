package com.example.app.service;

import com.example.app.domain.User;

public interface UserService {
	
	User getUserById(String login_id) throws Exception;
	
	void addUser(User user) throws Exception;
	
	boolean isCorrectIdAndPass(String login_id, String login_pass) throws Exception;
}
