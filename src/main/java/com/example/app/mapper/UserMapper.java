package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserMapper {

	// IDの重複確認
	User findByLoginId(String loginId) throws Exception;

	// ユーザー登録
	void insert(User user) throws Exception;

}
