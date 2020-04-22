package com.dpflsy.board.springboot.config.auth;

import com.dpflsy.board.springboot.domain.user.Role;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //h2-console 화면을 사용하기 위해 해당 옵션들을 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    //URL별 권한 관리를 설정하는 옵션의 시작점
                    //authorizeRequests가 선언되어야만 antMatchers 옵션을 사용할 수 있음
                    .authorizeRequests()
                    .antMatchers("/","/css/**","/images/**", "/js/**","/h2-console/**").permitAll()
                    //권한 관리 대상 지정
                    //URL, Http 메소드별로 관리 가능
                    //지정된 URL은 전제 열람 가능
                    //POST 메소드면서 "/api/v1/**" 주소가 가진 API는 USER 권한을 가진 사람만 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //설정된 값들 이외 나머지 URL을 나타냄
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")//로그아웃 시 /주소로 이동
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);//소셜 로그인 성공 시 후속 조치 진행할 UserService 인터페이스의 구현체 등록
    }
}
