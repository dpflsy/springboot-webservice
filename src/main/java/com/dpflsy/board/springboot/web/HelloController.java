package com.dpflsy.board.springboot.web;
import com.dpflsy.board.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 변환하는 컨트롤러로 만들어줌
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    //롬복으로 대체한 HelloController 테스트 - HelloResponseDto, HelloResponseDtoTest 참조
    @GetMapping("/hello/dto")
    //RequestParam => 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 "name","amount"로 넘긴 파라미터를 메소드 마라미터 String name, int amount에 저장
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
