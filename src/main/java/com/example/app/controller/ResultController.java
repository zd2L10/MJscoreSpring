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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Result;
import com.example.app.domain.User;
import com.example.app.service.ResultService;

@Controller

public class ResultController {

	@Autowired
	ResultService resultservice;
	
	@Autowired
	HttpSession session;
	
	private static final int NUM_PER_PAGE = 10;
	
	@GetMapping("/result")
	public String list(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		/* model.addAttribute("resultList", resultservice.AllResult(user.getId())); */
		model.addAttribute("resultList", resultservice.getResultListByPage(user.getId(), page, NUM_PER_PAGE));
		model.addAttribute("page", page);
		model.addAttribute("totalPage", resultservice.getTotalPages(user.getId(), NUM_PER_PAGE));
		return "result/list";
	}
	
	@GetMapping("/result/add")
	public String addGet(Model model) throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		Result result = new Result();
		result.setUserId(user.getId());		
		model.addAttribute("result", result);
		model.addAttribute("title", "登録");
		return "result/save";
	}
	
	@PostMapping("/result/add")
	public String addPost(
			HttpSession session,
			@Valid Result result,
			Errors errors,
			Model model) throws Exception{
		// 参加プレイヤーの重複
		if((!result.getEastPlayer().isBlank()) && (!result.getSouthPlayer().isBlank()) && (!result.getWestPlayer().isBlank()) && (!result.getNorthPlayer().isBlank()) && (result.getEastPlayer() == result.getSouthPlayer() || result.getEastPlayer() == result.getWestPlayer() || result.getEastPlayer() == result.getNorthPlayer() || result.getSouthPlayer() == result.getWestPlayer() || result.getSouthPlayer() == result.getNorthPlayer() || result.getWestPlayer() == result.getNorthPlayer())){
			errors.rejectValue("deplayer", "player.depl");
		}
		
		// 10万点越え
		if ((result.getEastScore() != null) && (result.getSouthScore() != null) && (result.getWestScore() != null) && (result.getNorthScore() != null) && (result.getEastScore() + result.getSouthScore() + result.getWestScore() + result.getNorthScore()) != 100000) {
			errors.rejectValue("ovscore", "score.over");
		}
		
		
		
		// 入力不備
		if(errors.hasErrors()) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
			model.addAttribute("title", "登録");
			return "result/save";
		}
		
		// データベースに追加
		resultservice.addResult(result);
		model.addAttribute("title", "登録");
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "result/done";
	}
	
	@GetMapping("/result/edit/{id}")
	public String editGet(@PathVariable Integer id, Model model)throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("title", "編集");
		model.addAttribute("result", resultservice.getResultById(id));
		return "result/save"; 
	}
	
	@PostMapping("/result/edit/{id}")
	public String editPost(
			HttpSession session,
			@Valid Result result,
			Errors errors,
			Model model) throws Exception{
		// 参加プレイヤーの重複
		if((!result.getEastPlayer().isBlank()) && (!result.getSouthPlayer().isBlank()) && (!result.getWestPlayer().isBlank()) && (!result.getNorthPlayer().isBlank()) && (result.getEastPlayer() == result.getSouthPlayer() || result.getEastPlayer() == result.getWestPlayer() || result.getEastPlayer() == result.getNorthPlayer() || result.getSouthPlayer() == result.getWestPlayer() || result.getSouthPlayer() == result.getNorthPlayer() || result.getWestPlayer() == result.getNorthPlayer())){
			errors.rejectValue("deplayer", "player.depl");
		}
		// 10万点越え
		if ((result.getEastScore() + result.getSouthScore() + result.getWestScore() + result.getNorthScore()) != 100000) {
			errors.rejectValue("ovscore", "score.over");
		}
				
		// 入力不備
		if(errors.hasErrors()) {
			model.addAttribute("title", "編集");
			return "result/save";
		}
				
		// データベースに追加
		resultservice.editResult(result);
		model.addAttribute("title", "修正");
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "result/done";	
	}
	
	@GetMapping("/result/{id}")
	public String detailGet(@PathVariable Integer id,Model model) throws Exception{
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("result", resultservice.getResultById(id));
		return "result/detail";
	}
	
	@GetMapping("/result/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes rd) throws Exception{
		resultservice.deleteResult(id);
		rd.addFlashAttribute("statusMessage", "対局記録を削除しました。");
		return "redirect:/result";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/logout";
	}
	
}
