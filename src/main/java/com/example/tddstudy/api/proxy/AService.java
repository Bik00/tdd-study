package com.example.tddstudy.api.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AService implements AServiceInterface {
    public String sendHello() {
        // 2초가 걸리는 아주 무거운 어떤 작업을 실제 객체가 합니다.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
