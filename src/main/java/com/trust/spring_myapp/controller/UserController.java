package com.trust.spring_myapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trust.spring_myapp.entity.Users;
import com.trust.spring_myapp.form.UserForm;
import com.trust.spring_myapp.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	String list(Model model) {
		// DBのレコードを取得しModelオブジェクトに追加
		List<Users> user = userService.findAll();
		model.addAttribute("users", user);
		return "list";
	}
	
	// 登録画面へ遷移
	@GetMapping("signup")
	// Modelオブジェクトにセット、画面とコントローラークラスの値のやりとり、
	String signup(@ModelAttribute UserForm userForm) {
		return "signup";
	}
	
	// 登録画面の登録ボタンを押下した際に呼び出されるメソッド
	@PostMapping("signup")
	String regist(@ModelAttribute UserForm userForm) {
		Users users = new Users();
		// userFormの値をusersにコピー
		BeanUtils.copyProperties(userForm, users);
		// userServiceクラスに登録したinsert()メソッドでデータベースに登録
		userService.insert(users);
		//
		return "redirect:/";
	}
	
}
