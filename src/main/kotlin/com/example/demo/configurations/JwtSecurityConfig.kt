//package com.example.demo.configurations
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//
//@Configuration
//class JwtSecurityConfig : WebSecurityConfigurerAdapter() {
//    override fun configure(http: HttpSecurity) {
//        http.authorizeRequests()
//            .antMatchers("/api").anonymous()
//            .antMatchers("/api/tasks").hasAnyAuthority().anyRequest().authenticated()
//
//    }
//}
