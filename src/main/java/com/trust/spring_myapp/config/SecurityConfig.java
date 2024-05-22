package com.trust.spring_myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
        	// ログインの処理をするURL
            .loginProcessingUrl("/login")
            // ログイン画面のURL
            .loginPage("/login")
            // ログインが成功した際に遷移されるURL
            .defaultSuccessUrl("/")
            // ログイン画面のhtmlのinputのname属性
            .usernameParameter("email")
            .passwordParameter("password")
            // ログインに失敗した際のURL
            .failureUrl("/login?error")
            .permitAll()
        ).logout(logout -> logout
        	// ログアウトした際のURLs
            .logoutSuccessUrl("/login")
        ).authorizeHttpRequests(authz -> authz
            .requestMatchers("/css/**", "/webjars/**").permitAll()
            .requestMatchers("/login", "/signup").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}