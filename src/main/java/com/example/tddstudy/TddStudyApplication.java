package com.example.tddstudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TddStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TddStudyApplication.class, args);
    }
}
// 스프링이 구동될 때
// 스프링은 혼자서는 실행이 안됩니다.

// 톰캣이 실행해줘야 됨..
// 스프링 프레임워크는 web.xml -> 톰캣이 제공해주는 파일이 필요

// 스프링 계층 구조
// 자바 -> Object class

// 스프링의 가장 최상위 클래스는 ??
// BeanFactory -> 스프링 @Component, @Service, @Controller -> 스프링 빈
// ApplicationConenxt -> 빈들을 빈 저자장소에에 등록시켜주고, 관리해주는 객체.

interface AInterface {}

@Component
class AClass implements AInterface { //-> 빈저장소

}

// cglib 방식
class AClassProxy extends AClass {

}

// dynamic proxy

@Configuration
class Config {

    @Bean
    AClass aClass() {
        return new AClass();
    }

}