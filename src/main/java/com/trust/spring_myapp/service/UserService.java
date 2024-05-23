package com.trust.spring_myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.spring_myapp.domain.Users;
import com.trust.spring_myapp.repository.UserRepository;

/**
 * 
 * @Service		サービスクラスであることを示し、クラスのBeanをDIコンテナに登録する
 * @Transactional		DBのトランザクション制御
 * */
@Service
@Transactional
public class UserService {
	// DIを行う為に「@Autowired」を付与する
    @Autowired
    UserRepository userRepository;

    // 全件取得（ID昇順）メソッド
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
    public Optional<Users> selectById(Integer id) {
        return userRepository.findById(id);
    }
}
