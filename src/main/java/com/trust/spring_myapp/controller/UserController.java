package com.trust.spring_myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.trust.spring_myapp.domain.Users;
import com.trust.spring_myapp.form.UserForm;
import com.trust.spring_myapp.service.UserService;

/**
 * 
 * ユーザー情報 Service
 */
@Controller
public class UserController {
	@Autowired
    UserService userService;

	/**
	   * ユーザー情報一覧画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	@GetMapping("/")
    String list(Model model) {
        // DBのレコードを取得
        List<Users> users = userService.findAll();
        model.addAttribute("users", users);
        return "list";
    }
	// URLクエリに「signup」を設定したGETリクエスト
    @GetMapping("signup")
    // Modelオブジェクトにセットし、画面とコントローラークラスの値のやりとりを行えるようにする
    String signup(@ModelAttribute UserForm userForm) {
        return "signup";
    }

}
