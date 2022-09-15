package com.example.app.mapper;

import com.example.app.domain.User;

public interface UserMapper {

	// IDの重複確認
	User findByLogin_id(String login_id) throws Exception;

	// ユーザー登録
	void insert(User user) throws Exception;

	// ログイン認証
	User findByLogin_idAndLogin_pass(String login_id, String login_pass) throws Exception;

}
