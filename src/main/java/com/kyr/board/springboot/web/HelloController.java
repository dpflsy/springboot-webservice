package com.kyr.board.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 변환하는 컨트롤러로 만들어줌
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
