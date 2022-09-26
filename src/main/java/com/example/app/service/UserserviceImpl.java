package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserserviceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserById(String login_id) throws Exception {
		return userMapper.findByLogin_id(login_id);
	}

	@Override
	public void addUser(User user) throws Exception {
		userMapper.insert(user);
		
	}

	@Override
	public boolean isCorrectIdAndPass(String login_id, String login_pass) throws Exception {
		User user = userMapper.findByLogin_id(login_id);
		
		// ログインIDが正しいかチェック
		if(user == null) {
			return false;
		}
		
		// パスワードが正しいかチェック
		if(!BCrypt.checkpw(login_pass, user.getLogin_pass())) {
			return false;
		}
		
		return true;
	}

	

}
