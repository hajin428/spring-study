package com.sparta.springauth.food;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//@Qualifier("이름") : 주입해줄 클래스에 추가해주고 주입하고자 하는 필드에도 똑같은 이름으로 추가하면 해당 bean 객체 사용 가능

@Component
@Qualifier("pizza")
public class Pizza implements Food {
    @Override
    public void eat() {
        System.out.println("피자를 먹습니다.");
    }
}
