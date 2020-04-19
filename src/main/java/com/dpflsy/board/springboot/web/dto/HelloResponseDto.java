//HelloController를 롬복으로 대체
package com.dpflsy.board.springboot.web.dto;
//롬복을 사용하는 이유: 자바 개발시 자주 사용하는 어노테이션(getter,setter,기본 생성자 등)을 어노테이션으로 자동 생성
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get메소드를 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성 (final 필드가 반드시 있어야함)
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
