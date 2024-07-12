package com.luv2code.springboot.thymeleafdemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource source){
        return new JdbcUserDetailsManager(source);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests( configurer ->
                configurer
                        .anyRequest().authenticated()
        ).formLogin(form ->
                        form
                                .loginPage("/employees/showMyLoginPage")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll()
        ).logout(
        logout -> logout.permitAll()
        ).exceptionHandling(
                configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
        );
        return http.build();
    }

}
