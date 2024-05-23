package com.trust.spring_myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trust.spring_myapp.form.UserForm;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@GetMapping
	public String getSignup(Model model) {
		model.addAttribute("signupForm", new UserForm());
		return "signup";
	}
	
	@PostMapping
	public String postSignup(UserForm form) {
		return "redirect;/login";
	}
}