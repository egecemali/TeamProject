package com.teams.project.security;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails ege = User.builder().username("ege").password("{noop}123").roles("USER").build();
        UserDetails baran = User.builder().username("baran").password("{noop}234").roles("USER","MANAGER").build();
        UserDetails Admin = User.builder().username("admin").password("{noop}345").roles("USER","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(ege, baran, Admin);

    }*/

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager.setUsersByUsernameQuery("select * from members where username=? ");
        theUserDetailsManager.setAuthoritiesByUsernameQuery("select username,authority from roles where username=?");

        return theUserDetailsManager;



    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET,"/api/**").hasAnyRole("USER","MANAGER","ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/players/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT,"/api/players/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/teams/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/playerInfo/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/playerInfo/**").hasAnyRole("USER","MANAGER","ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/playerInfo/**").hasAnyRole("USER","MANAGER","ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/teams/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/players/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/cups/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/playerInfo/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN"));


        //use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf-> csrf.disable());
        return http.build();

    }



}
