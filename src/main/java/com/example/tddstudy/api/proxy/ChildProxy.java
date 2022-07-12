package com.example.tddstudy.api.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// 스프링 애플리케이션 컨텍스트에 담긴 Parent Proxy 객체
@Service
@Slf4j
public class ChildProxy extends Parent {

    @Override
    public String printNumber1() {
        log.info("부가 기능 수행! ");
        return super.printNumber1();
    }
}
