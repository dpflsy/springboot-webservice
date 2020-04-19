package com.dpflsy.board.springboot.web.domain.posts;

import com.dpflsy.board.springboot.domain.posts.Posts;

import com.dpflsy.board.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //JUnit 단위 테스트가 끝날 때마다 수행되는 메소드를 저장
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void open_saveBoard(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        //테이블 posts에 insert / update 쿼리를 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("dpflsy@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //테이블 posts의 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void registBaseTimeEntitiy(){
        LocalDateTime now = LocalDateTime.of(2020,4,14,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);


        System.out.println(">>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
