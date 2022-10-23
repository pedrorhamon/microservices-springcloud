package com.starking.eurekaserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {

//	@Bean
//	public void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf()
//		.disable()
//		.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic();
//	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .httpBasic();
        http.csrf().ignoringAntMatchers("/eureka/**");
        return http.build();
    }
}
