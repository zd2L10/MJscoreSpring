package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.Result;
import com.example.app.mapper.ResultMapper;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	ResultMapper resultMapper;

	@Override
	public List<Result> AllResult(Integer id) throws Exception {
		return resultMapper.findNewerResults(id);
	}

	@Override
	public Result getResultById(Integer id) throws Exception {
		return resultMapper.findById(id);
	}

	@Override
	public void addResult(Result result) throws Exception {
		resultMapper.insert(result);
	}

	@Override
	public void editResult(Result result) throws Exception {
		resultMapper.update(result);
	}

	@Override
	public void deleteResult(Integer id) throws Exception {
		resultMapper.delete(id);
	}
	
	
	

}
