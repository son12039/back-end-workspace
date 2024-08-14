package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정

	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf->csrf.disable())
				.httpBasic(basic-> basic.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeRequests(authorize ->
					authorize
					.requestMatchers("/member").authenticated()
					.requestMatchers("/admin").hasRole("ADMIN") // 권한이 ADMIN인 경우만 들어올 수 있음
					// /member 요청이 들어왔을 때 인증된 사람만
					.anyRequest().permitAll()
				)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		
	}
	
}
//.formLogin(login -> 
//login
//.loginPage("/login")
//.defaultSuccessUrl("/",false)
//.permitAll()
//)