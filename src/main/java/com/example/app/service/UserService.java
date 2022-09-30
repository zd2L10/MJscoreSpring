package com.example.app.service;

import com.example.app.domain.User;

public interface UserService {
	
	User getUserById(String loginId) throws Exception;
	
	void addUser(User user) throws Exception;
	
	boolean isCorrectIdAndPass(String loginId, String loginPass) throws Exception;
}
