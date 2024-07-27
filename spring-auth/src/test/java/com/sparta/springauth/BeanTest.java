package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    @Autowired
    @Qualifier("pizza")
    Food food;

    @Autowired
    Food chicken;

    @Autowired
    Food pizza;

    //Bean이 두 개 이상일 때는 사용하려는 bean의 이름을 정확하게 명시해주면 사용 가능
    //@Autowired는 bean으로 의존성 주입을 지원함

    @Test
    @DisplayName("테스트")
    void test1() {

        //pizza 객체에 eat 메서드
        pizza.eat();
        chicken.eat();
    }
















}
