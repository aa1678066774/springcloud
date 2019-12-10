package com.tww.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-09 16:13
 */
@EnableWebSecurity
public class MySercurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        // 定制请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        http.formLogin();
        http.logout().logoutSuccessUrl("/");
    }

    // 自定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("human").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1")
                .and()
                .withUser("angle").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
                .and()
                .withUser("god").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2", "VIP3");
    }
}
