package com.kodilla.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/createBean").hasRole("BASIC")
                        .requestMatchers("/v1/calculator/**").hasRole("BASIC")
                        .requestMatchers("/task1.1/**", "/task1.2/**", "/task3.3/read/**", "/task4.2/read/**").hasRole("BASIC")
                        .requestMatchers("/task2.2/**", "/task3.1/**", "/task3.3/create/**", "/task3.3/update/**").hasRole("ADVANCED")
                        .requestMatchers("/task1.4/**", "/task2.1/**", "/task2.3/**", "/task3.3/delete/**", "/task4.2/create/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails basicUser = User.withUsername("basicUser")
                .password(passwordEncoder().encode("password"))
                .roles("BASIC")
                .build();

        UserDetails advancedUser = User.withUsername("advancedUser")
                .password(passwordEncoder().encode("password"))
                .roles("BASIC", "ADVANCED")
                .build();

        UserDetails adminUser = User.withUsername("adminUser")
                .password(passwordEncoder().encode("password"))
                .roles("BASIC", "ADVANCED", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(basicUser, advancedUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
