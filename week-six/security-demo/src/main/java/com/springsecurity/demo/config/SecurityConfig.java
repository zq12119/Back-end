package com.springsecurity.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
//    密码加密
    PasswordEncoder passwordEncoder(){
//        设置不进行密码加密已过时
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder authen)throws Exception{
//        使用内存进行身份验证
        authen.inMemoryAuthentication()
//                配置用户名 密码
                .withUser("admin").password("$2a$10$/D8ygfY2SGH96v9pmfP/CuNVpP14vQlpHUd76xItMkM517wSaWWXu").roles("admin")
                .and()
                .withUser("user").password("$2a$10$JtcAGG9GuP3bY28gYN8Qbum9Zkx45mqULng3j2iKcUnutXZygGnE2").roles("user");
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
//        开启匹配
        http.authorizeRequests()
//               配置URl路径和角色
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasAnyRole("admin","user")
                .anyRequest().authenticated()
                .and()
//                表单登录
                .formLogin()
//                处理登录请求url地址，默认是login
                .loginProcessingUrl("/doLogin")
//                登录用户名的属性字符串
                .usernameParameter("username")
//                登录密码是数组字符串
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        Map<Object,Object> map=new HashMap<>();
                       map.put("status",200);
                       map.put("msg",authentication.getPrincipal());
                       out.write(new ObjectMapper().writeValueAsString(map));
                       out.flush();
                       out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        Map<Object,Object> map=new HashMap<>();
                        map.put("status",401);
                            if(e instanceof LockedException) {
                                map.put("mag", "账户被锁定，登录失败");
                            }else if(e instanceof BadCredentialsException){
                                map.put("msg","用户名密码错误，登录失败");
                            }else if(e instanceof DisabledException){
                                map.put("msg","账户被禁用，登录失败");
                            }else if(e instanceof AccountExpiredException){
                                map.put("msg","账户过期，登录失败");
                            }else if(e instanceof CredentialsExpiredException){
                                map.put("msg","密码过期，登录失败");
                            }else {
                                map.put("msg","未知错误");
                            }
                            out.write(new ObjectMapper().writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                })
//                与登录相关的请求
                .permitAll()
                .and()
                .logout()
                .logoutUrl("logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out=response.getWriter();
                        Map<Object,Object> map=new HashMap<>();
                        map.put("status",200);
                        map.put("msg","注册成功");
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .and()
//                关闭方csrf攻击，用于postman测试
                .csrf().disable();
    }
}
