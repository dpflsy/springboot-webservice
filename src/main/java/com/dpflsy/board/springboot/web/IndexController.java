package com.dpflsy.board.springboot.web;

import com.dpflsy.board.springboot.config.auth.dto.SessionUser;
import com.dpflsy.board.springboot.domain.user.User;
import com.dpflsy.board.springboot.service.PostsService;
import com.dpflsy.board.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        //로그인 성공시 세션에 SessionUser를 저장
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //로그인 성공 시 getAttribute에 값을 가져옴

        if(user != null){
            model.addAttribute("userName",user.getName()); //세션에 저장된 값이 있을때만 model에 userName으로 등록
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}