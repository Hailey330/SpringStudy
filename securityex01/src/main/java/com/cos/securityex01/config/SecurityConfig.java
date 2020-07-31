package com.cos.securityex01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // IoC에 Bean(빈) 을 등록
@EnableWebSecurity // // 필터 체인 관리할 수 있는 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소 접근시 권한 및 인증을 미리 체크함 (Controller 접근 전에 낚아서 처리)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   // 해당 주소만 잠그고 나머지 다 열어 놓음
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
         .antMatchers("/user/**","/admin/**")
         .authenticated()
         .anyRequest()
         .permitAll()
      .and()
         .formLogin()
         .loginPage("/login") // 잠근 페이지를 해당 페이지로 맵핑
         .loginProcessingUrl("/loginProc") // login.mustache 에서 post 방식으로 보냄
         .defaultSuccessUrl("/"); // 성공 시 redirection되는 페이지 
   }
}