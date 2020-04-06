package com.kyr.board.springboot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

}
