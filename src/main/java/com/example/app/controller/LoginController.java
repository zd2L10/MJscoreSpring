package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.User;
import com.example.app.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid User user,
			Errors errors,
			HttpSession session) throws Exception {
		
		// 入力不備確認のバリデーション
		if(errors.hasErrors()) {
			return "login/login";
		}
		// 
		if(!service.isCorrectIdAndPass(user.getLogin_id(), user.getLogin_pass())) {
			errors.rejectValue("login_id", "error.incorrect_id_password");
			return "login/login";
		}
		
		session.setAttribute("login_id", user.getLogin_id());
		return "redirect:/login";
	}
	
	@GetMapping("/add")
	public String addGet (Model model) throws Exception {
		model.addAttribute("user", new User());
		return "login/add";
	}
	
	@PostMapping("/add")
	public String addPost(
			@Valid User user,
			Errors errors,
			Model model) throws Exception{
		if(errors.hasErrors()) {
			return "login/add";
		}
		if(!user.getConfpass().equals(user.getLogin_pass())) {
			errors.rejectValue("confpass", "confpass.not.same");
		}
		User tempUser = null;
		tempUser = service.getUserById(user.getLogin_id());
		if(tempUser != null) {
			errors.rejectValue("login_id", "login_id.in.use");
		}
		service.addUser(user);
		return "redirect:/login/addDone";
	}
	
}
