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
	
	@Autowired
	HttpSession session;
	
	@GetMapping
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login/login";
	}
	
	@PostMapping
	public String login(
			@Valid User user,
			Errors errors,
			HttpSession session) throws Exception {
		
		// 
		if(!service.isCorrectIdAndPass(user.getLoginId(), user.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
		}
		// 入力不備確認のバリデーション
		if(errors.hasErrors()) {
			return "login/login";
		}
		
		session.setAttribute("user", service.getUserById(user.getLoginId()));
		return "redirect:/result";
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
		User tempUser = null;
		tempUser = service.getUserById(user.getLoginId());
		if(tempUser != null) {
			errors.rejectValue("loginId", "login_id.in.use");
		}
		if(!user.getConfpass().equals(user.getLoginPass())) {
			errors.rejectValue("confpass", "confpass.not.same");
		}
		if(errors.hasErrors()) {
			return "login/add";
		}
		model.addAttribute("user", user);
		service.addUser(user);
		return "redirect:/login/addDone";
	}
	
	@GetMapping("/addDone")
	public String addDone() {
		return "login/addDone";
	}
	
}
