package com.kyr.board.springboot.domain.posts;

import com.kyr.board.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok
@NoArgsConstructor //lombok (기본 생성자를 자동으로 추가시킴) pulic Posts(){}와 같은 효과
@Entity //JPA - 클래스와 링크될 클래스임을 나타낸다
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) //varchar(500), not null
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //타입 TEXT, not null
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성 (@Setter 대신 사용)
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
