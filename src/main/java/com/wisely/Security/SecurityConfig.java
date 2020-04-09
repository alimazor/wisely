package com.wisely.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by ali on 07/04/20.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin();
       //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/home").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/newQuote","/editQuotes","/saveQuote","/allQuotes","/deleteQuotes").hasAnyRole("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ali").password("{noop}123").roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("khawla").password("{noop}123").roles("USER");
    }
}
