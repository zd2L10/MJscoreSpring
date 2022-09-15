package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Result;

public interface ResultMapper {

	// 記録を新しい順に取得
	List<Result> findNewerResults(int user_id) throws Exception;

	Result findResult(int user_id) throws Exception;

	// 記録の追加、編集、削除
	void insert(Result result) throws Exception;

	void update(Result result) throws Exception;

	void delete(int result_id, int user_id) throws Exception;

	// 任意のデータ1件を呼び出し
	Result findById(int result_id, int user_id) throws Exception;

}
