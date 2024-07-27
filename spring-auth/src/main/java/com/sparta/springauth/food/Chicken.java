package com.sparta.springauth.food;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Primary : 같은 타입의 bean이 여러개 있을 때 우선적으로 주입되는 객체
public class Chicken implements Food {
    //@Override: 상위 클래스의 메서드를 하위 클래스에서 상속 받았을 때 하위 클래스에서 재정의 하는 어노테이션
    @Override
    public void eat() {
        System.out.println("치킨을 먹습니다.");
    }
}