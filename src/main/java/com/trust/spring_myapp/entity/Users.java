package com.trust.spring_myapp.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data               // Getter,Setterが不要になる
@NoArgsConstructor  // デフォルトコンストラクターの自動生成
@AllArgsConstructor // 全フィールドに対する初期化値を引数に取るコンストラクタを自動生成
public class Users {
	// 主キーに当たるフィールドに付与(id)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// NotNull制約を示す
	@Column(nullable = false)
	private Integer id;
	private String name;
	private String email;
	private String password;
}