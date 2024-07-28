package com.sparta.springjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        //비밀번호를 암호화하기 위한 메서드
        return new BCryptPasswordEncoder();
    }

    @Bean
    //인자로 httpSecurity를 받고 예외 처리 해줌
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 보호와 기본적인 인증 방식 비활성화(disable)

        //csrf disable
        http
                .csrf((auth) -> auth.disable());

        //From 로그인 방식 disable
        http
                .formLogin((auth) -> auth.disable());

        //http basic 인증 방식 disable
        http
                .httpBasic((auth) -> auth.disable());



        //경로별 인가 작업
        http
                //authorizeHttpRequests:  http 요청에 대한 인증
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/", "/join").permitAll() //특정 경로에 대해서는 인증 생략
                        .requestMatchers("/admin").hasRole("ADMIN") //"/admin"경로에 대해서는 ADMIN 사용자만 접근 가능
                        .anyRequest().authenticated()); //나머지 모든 요청에 대해서는 인증 요구

        //세션 설정
        http
                .sessionManagement((session) -> session //sessionManagment : 세션 관리
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //세션을 Stateless 상태로 관리

        /*
        세션을 Stateless 상태로 관리하는 이유
        Stateless 방식은 서버가 클라이언트의 이전 요청을 기억하지 않고, 각 요청을 독립적으로 처리하는 방식
        RESTful Api와 호환됨
         */

        return http.build();
    }
}
