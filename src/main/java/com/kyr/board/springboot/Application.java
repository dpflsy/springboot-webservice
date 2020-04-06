package com.kyr.board.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication : 스프링 부트의 자동설정, 스프링 Bean읽기와 생성이 모두 자동으로 설정, 이 위치부터 설정을 읽음 => 최상단에 위치해야함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
