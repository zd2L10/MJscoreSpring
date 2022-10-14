package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Result;

@Mapper
public interface ResultMapper {

	// 記録を新しい順に取得
	List<Result> findNewerResults(Integer userId) throws Exception;
	
	// 任意のデータ1件を呼び出し
	Result findById(Integer resultId) throws Exception;

	// 記録の追加、編集、削除
	void insert(Result result) throws Exception;

	void update(Result result) throws Exception;

	void delete(Integer resultId) throws Exception;

	// ページ分割
	// 合計ページ
	Long countResult(Integer userId) throws Exception;
	
	// 分割後の表示件数
	List<Result> selectLimited(@Param("id") Integer userId, @Param("offset") int offset, @Param("limit") int limit) throws Exception;
}
