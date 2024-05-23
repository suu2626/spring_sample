package com.trust.spring_myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// パスワードエンコーダー
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// httpオブジェクトのformLoginメソッドを呼び出しフォームベースのログイン設定を行う
		// login	(フォームログインの詳細設定を行うためのラムダ式の引数)
        http.formLogin(login -> login
        	// ログインの処理を行うURL
            .loginProcessingUrl("/login")
            // カスタムログイン画面のURL
            .loginPage("/login")
            // ログインが成功した際に遷移されるURL
            .defaultSuccessUrl("/")
            // ログイン画面のhtmlのinputのname属性
            .usernameParameter("email")
            .passwordParameter("password")
            // ログインに失敗した際のURL
            .failureUrl("/login?error").permitAll()
        // logout設定の呼び出し
        ).logout(logout -> logout
        	// ログアウトした際のURL	
            .logoutSuccessUrl("/login")
        // HTTPリクエストに対する認可設定 authz(認可設定を行うためのラムダ式の引数)
        ).authorizeHttpRequests(authz -> authz
        	// 全てのユーザーにリクエストを許可するパス
            .requestMatchers("/css/**", "/webjars/**").permitAll() // permitAll()常にアクセスを許可
            .requestMatchers("/login", "/signup", "/list").permitAll() // denyAll()	常にアクセスを拒否
            .anyRequest()
            .authenticated()
        );
        return http.build();
    }
}