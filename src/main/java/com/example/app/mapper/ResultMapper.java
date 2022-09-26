package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Result;

@Mapper
public interface ResultMapper {

	// 記録を新しい順に取得
	List<Result> findNewerResults(int user_id) throws Exception;

	// 記録の追加、編集、削除
	void insert(Result result) throws Exception;

	void update(Result result) throws Exception;

	void delete(@Param("result_id")int result_id, @Param("user_id")int user_id) throws Exception;

	// 任意のデータ1件を呼び出し
	Result findById(@Param("result_id")int result_id, @Param("user_id")int user_id) throws Exception;

}
