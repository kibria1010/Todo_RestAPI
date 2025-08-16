package org.example.rest_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Authorize any request
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated());
        // if not authenticated -> show default page
        http.httpBasic(Customizer.withDefaults());

        http.sessionManagement(
                seesion -> seesion
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // csrf -> disable for POST AND PUT
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails userDetails1 = getUserDetails("username", "kibria");
        UserDetails userDetails2 = getUserDetails("azim", "123");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails getUserDetails(String username, String password) {

        UserDetails userDetails = User.withUsername(username)
                .password("{noop}"+ password)
                .authorities("read")
                .roles("USER")
                .build();

        return userDetails;
    }
*/
}
