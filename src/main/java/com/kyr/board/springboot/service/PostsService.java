package com.kyr.board.springboot.service;

import com.kyr.board.springboot.domain.posts.Posts;
import com.kyr.board.springboot.domain.posts.PostsRepository;
import com.kyr.board.springboot.web.dto.PostsListResponseDto;
import com.kyr.board.springboot.web.dto.PostsResponseDto;
import com.kyr.board.springboot.web.dto.PostsSaveRequestDto;
import com.kyr.board.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id = "+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));
        return new PostsResponseDto(entity);
    }
    //posts의 stream을 map을 통해 PostsListResponseDto 변환 -> List 변환하는 메소드
    @Transactional(readOnly = true) //트랜잭션 범위 유지, 조회 속도 개선
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
}
