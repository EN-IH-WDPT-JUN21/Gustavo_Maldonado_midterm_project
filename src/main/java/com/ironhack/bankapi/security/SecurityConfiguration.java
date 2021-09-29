package com.ironhack.bankapi.security;

import com.ironhack.bankapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/hello-world").permitAll()
                .mvcMatchers(HttpMethod.GET, "/my-account/**").hasAnyRole("ACCOUNT_HOLDER")
                .mvcMatchers(HttpMethod.PATCH, "/transfer/**").hasAnyRole("ACCOUNT_HOLDER")
                .mvcMatchers(HttpMethod.PATCH, "/admin/account/**").hasAnyRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/client/new").hasAnyRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/account/checking").hasAnyRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "admin/new").hasAnyRole("SUPER_ADMIN")
                .anyRequest().permitAll();
    }
}
