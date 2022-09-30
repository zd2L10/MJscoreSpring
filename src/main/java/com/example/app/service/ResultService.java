package com.example.app.service;

import java.util.List;

import com.example.app.domain.Result;

public interface ResultService {

	// 結果リストを表示
	List<Result> AllResult(Integer id) throws Exception;
	
	// 任意のデータ1件を呼び出し
	Result getResultById(Integer id) throws Exception;
	
	// データを1件追加
	void addResult (Result result) throws Exception;
	
	// データを更新
	void editResult (Result result) throws Exception;
	
	// データを削除
	void deleteResult (Integer id) throws Exception;
	
}
