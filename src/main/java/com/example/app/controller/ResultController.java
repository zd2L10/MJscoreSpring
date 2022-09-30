package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Result;
import com.example.app.domain.User;
import com.example.app.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController {

	@Autowired
	ResultService resultservice;
	
	@Autowired
	HttpSession session;
	
	@GetMapping
	public String list(Model model) throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("resultList", resultservice.AllResult(user.getId()));
		return "result/list";
	}
	
	@GetMapping("/add")
	public String addGet(Model model) throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("result", new Result());
		model.addAttribute("title", "登録");
		return "result/save";
	}
	
	@PostMapping("/add")
	public String addPost(
			HttpSession session,
			@Valid Result result,
			Errors errors,
			Model model) throws Exception{
		// 参加プレイヤーの重複
		if(result.getEastPlayer() == result.getSouthPlayer() || result.getEastPlayer() == result.getWestPlayer() || result.getEastPlayer() == result.getNorthPlayer() || result.getSouthPlayer() == result.getWestPlayer() || result.getSouthPlayer() == result.getNorthPlayer() || result.getWestPlayer() == result.getNorthPlayer()){
			errors.rejectValue("player", "player.depl");
		}
		// 10万点越え
		if ((result.getEastScore() + result.getSouthScore() + result.getWestScore() + result.getNorthScore()) != 100000) {
			errors.rejectValue("score", "score.over");
		}
		
		// 入力不備
		if(errors.hasErrors()) {
			return "result/save";
		}
		
		// データベースに追加
		resultservice.addResult(result);
		// リダイレクト
		model.addAttribute("title", "登録");
		return "redirecct:/done";
	}
	
	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer id, Model model)throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("title", "編集");
		model.addAttribute("result", resultservice.getResultById(id));
		return "result/save"; 
	}
	
	@PostMapping("/edit/{id}")
	public String editPost(
			HttpSession session,
			@Valid Result result,
			Errors errors,
			Model model) throws Exception{
		// 参加プレイヤーの重複
		if(result.getEastPlayer() == result.getSouthPlayer() || result.getEastPlayer() == result.getWestPlayer() || result.getEastPlayer() == result.getNorthPlayer() || result.getSouthPlayer() == result.getWestPlayer() || result.getSouthPlayer() == result.getNorthPlayer() || result.getWestPlayer() == result.getNorthPlayer()){
			errors.rejectValue("player", "player.depl");
		}
		// 10万点越え
		if ((result.getEastScore() + result.getSouthScore() + result.getWestScore() + result.getNorthScore()) != 100000) {
			errors.rejectValue("score", "score.over");
		}
				
		// 入力不備
		if(errors.hasErrors()) {
			return "result/save";
		}
				
		// データベースに追加
		resultservice.editResult(result);
		// リダイレクト
		model.addAttribute("title", "修正");
		return "redirecct:/done";	
	}
	
	@GetMapping("/done")
	public String done() {
		return "result/done";
	}
}