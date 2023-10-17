//package com.study.mybatis.common.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity  // spring security 설정 클래스
//@EnableGlobalMethodSecurity(securedEnabled = true)  // api 별 권한 제어를 위한 어노테이션
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//
//                // session 기반이 아닌 rest api를 이용한 서버는 서버에 인증 정보를 보관하지 않으므로,
//                // 사용자가 의도하지 않은 위조 요청을 검증해주는 csrf 설정을 해제하여도 된다.
//                .csrf().disable()
//                // Http basic Auth 기반의 로그인 인증 창, 비인증시 로그인폼 화면으로 리다이렉트해주지만, rest api 방식을 사용하므로 해제한다.
//                .httpBasic().disable()
//                // 일반적인 로그인 방식, ID/Password 로그인 방식 사용을 의미하지만 rest api이므로 해제해준다.
//                .formLogin().disable()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//                // STATELESS로 세션 정책을 설정한다는 것은, 세션쿠키 방식의 인증 메커니즘 방식을 사용하지 않겠다는 것을 의미
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//                .and()
//                // 예외 처리
//                .exceptionHandling()
//                // 401 에러 핸들링
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                // 403 에러 핸들링
//                .accessDeniedHandler(jwtAccessDeniedHandler)
//
//                .and()
//                // 리소스(URL)의 권한 설정
//                .authorizeRequests()
//                // 마이페이지 인증 필요
//                .antMatchers("/api/mypage/**").authenticated()
//                // 관리자페이지는 관리자 권한이 있는 사람만 접근 허용
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                // 나머지는 모두 허용
//                .anyRequest().permitAll()
//
//                .and()
//                .headers()
//                .frameOptions().sameOrigin();
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//}
