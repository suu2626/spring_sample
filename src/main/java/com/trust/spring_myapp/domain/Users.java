package com.trust.spring_myapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Entity	JPAのエンティティであることを示す
 * @Table		エンティティに対応するテーブル名を指定
 * @Data		getter、setterメソッド等を生成
 * @AllArgsConstructor		全ての引数を持つコンストラクタを生成
 * @NoArgsConstructor		引数を持たないコンストラクタを生成
 * */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	/**
	 * 
	 * @Id  	エンティティの主キー
	 * @GeneratedValue	主キーが自動採番されることを示す
	 * @Column		NotNull制約を示す
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String email;

}
