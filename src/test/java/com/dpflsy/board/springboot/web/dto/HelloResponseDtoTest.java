//HelloControllerTest를 롬복으로 대체
package com.dpflsy.board.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void testLombok(){
        //given
        String name = "Test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //assertj라는 테스트 검증 라이브러리의 검증 메소드 - 메소드 체이닝 지원
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
