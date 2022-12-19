package com.maliitourist.apigestionregions.apigestionregions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.FilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return  new InMemoryUserDetailsManager(
                User.withUsername("user1").password("{noop}1234").authorities("USER").build(),
                User.withUsername("user2").password("{noop}1234").authorities("USER").build(),
                User.withUsername("user3").password("{noop}1234").authorities("USER","ADMIN").build()

        );
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeRequests(auth->auth.anyRequest().authenticated())
                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
