package com.kyr.board.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit사이에 연결자 역할을 함
@WebMvcTest // Web에 집중할 수 있는 어노테이션 , 여기서는 컨트롤러만 사용하기에 선언
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; //웹 API를 테스트 , 스프링 MVC 테스트의 시작점

    @Test
    public void Returnhello() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 Get을 요청받음
            .andExpect(status().isOk()) //mvc.perform의 결과가 200인지 아닌지를 검증
            .andExpect(content().string(hello)); //결과 검증, 응답 본문의 내용이 맞는지 아닌지 검증
    }

    @Test
    public void ReturnHelloDto() throws Exception{
        String name = "hello";
        int amount = 10000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$name",is(name))) //json 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));

    }

}
