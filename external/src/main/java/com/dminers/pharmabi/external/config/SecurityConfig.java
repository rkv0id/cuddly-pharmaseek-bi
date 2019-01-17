package com.dminers.pharmabi.external.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/loggedout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("userpass"))
                .roles("USER")
                .and()
                .withUser("manager")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("managerpass"))
                .roles("MANAGER")
                .and()
                .withUser("other")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("otherpass"))
                .roles("OTHER");
    }

}
