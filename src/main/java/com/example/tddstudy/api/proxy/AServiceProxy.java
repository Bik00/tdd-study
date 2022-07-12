package com.example.tddstudy.api.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// 스프링 애플리케이션 컨텍스트에 담겨 있는 객체
@Slf4j
@Service("aServiceProxy")
@RequiredArgsConstructor
public class AServiceProxy implements AServiceInterface {

    private final AService service;
    private String cache;

    @Override
    public String sendHello() {
        if (cache != null) return cache;
        cache = service.sendHello();
        return cache;
    }
    //  proxy 덕분에 사용할 수 있습니다.
}