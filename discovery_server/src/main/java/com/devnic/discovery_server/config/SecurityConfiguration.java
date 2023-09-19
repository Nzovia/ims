//package com.devnic.discovery_server.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * @author Nicholas Nzovia
// * @On 18/09/2023
// * @Contact: itsdevelopernic22@gmail.com
// */
//
//@Configuration
//public class SecurityConfiguration {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("User")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests((auth)->auth
//                .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//}
