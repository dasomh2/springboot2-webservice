package com.dsheo.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //스프링 부트의 자동설정, 스프링 bean 읽기, 생성 모두 자동으로 설정. 여기부터 설정 읽어감 -> 최상단 위치해야함!
@EnableJpaAuditing //Auditing 활성화
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
