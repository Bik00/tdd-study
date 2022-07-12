package com.example.tddstudy.api.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AController {

    private final AServiceInterface service;
    private final Parent parent;

    public AController(@Qualifier("aServiceProxy") AServiceInterface service, Parent parent) {
        this.service = service;
        this.parent = parent;
    }

    // 사용자가 /request 요청을 보내게 되면
    // 응답은 hello로 간다.

    @GetMapping("/request")
    String sendHello() {
        parent.printNumber1();
        return service.sendHello();
    }
}
