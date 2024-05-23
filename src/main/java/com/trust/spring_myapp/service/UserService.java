package com.trust.spring_myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trust.spring_myapp.entity.Users;
import com.trust.spring_myapp.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	// SELECT * FROM USERSの処理
	public List<Users> findAll() {
		return userRepository.findAllOrderById();
	}
	// 登録処理
	public void insert(Users users) {
		userRepository.save(users);
	}
	// 更新処理
	public void update(Users users) {
		userRepository.save(users);
	}
	// 削除処理
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	// 1件取得
	public Optional<Users> selectById(Integer id){
		return userRepository.findById(id);
	}
}
