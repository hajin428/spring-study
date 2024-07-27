package com.sparta.springauth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration: Bean으로 등록한 메서드가 속한 클래스에 달아줌
@Configuration
public class PasswordConfig {

    //@Bean: bean임을 선언하는 어노테이션
    @Bean
    //bean으로 등록하고자 하는 객체를 반환하는 메서드 선언
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
        //PasswordEncoder는 인터페이스이므로 구현체를 넣어줘야됨
        //빈으로 등록한 객체를 주입 받으면 BCryptPasswordEncoder() 구현체 등록됨
        //BCrypt: 비밀번호를 암호화 해주는 hash 함수 <-이 함수를 사용해서 password를 encord해줌
    }
}
