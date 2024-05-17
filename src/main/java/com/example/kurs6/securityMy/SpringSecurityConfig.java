//package com.example.kurs6.securityMy;
//
//import com.example.kurs6.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig {
//
//    @Autowired
//    private UserService service;
//
//    @Autowired
//    private JwtTokenRepository jwtTokenRepository;
//
//    @Autowired
//    @Qualifier("handlerExceptionResolver")
//    private HandlerExceptionResolver resolver;
//
//    @Bean
//    public PasswordEncoder devPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .addFilterBefore(new JwtCsrfFilter(jwtTokenRepository, resolver), UsernamePasswordAuthenticationFilter.class)
//                .csrf(csrf -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/auth/login")))
//                .authorizeRequests()
//                .requestMatchers("/users/me").permitAll()
//                .requestMatchers("/auth/login").authenticated()
//                .anyRequest().permitAll();
//    }
//
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.service);
//    }
//
//}