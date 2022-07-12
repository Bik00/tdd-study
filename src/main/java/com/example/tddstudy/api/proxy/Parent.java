package com.example.tddstudy.api.proxy;

import org.springframework.stereotype.Service;


// 실제 개발자가 작성한 비즈니스 객체
@Service
public class Parent {

    public String printNumber1() {
        return "1";
    }
}
