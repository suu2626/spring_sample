package com.trust.spring_myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// パスワードエンコーダー
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	// 設定した情報でログインするためのメソッド
	@Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("test@email.com")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();
        manager.createUser(user);
        return manager;
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
            .requestMatchers("/login", "/signup").permitAll() // denyAll()	常にアクセスを拒否
            .anyRequest()
            .authenticated()
        );
        return http.build();
    }
}