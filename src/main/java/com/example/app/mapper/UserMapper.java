package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserMapper {

	// IDの重複確認
	User findByLogin_id(String login_id) throws Exception;

	// ユーザー登録
	void insert(User user) throws Exception;

}
