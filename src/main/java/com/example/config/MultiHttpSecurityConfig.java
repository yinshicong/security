//package com.example.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// *  我们可以配置多个httpSecurity，关键在于对WebSecurityConfigurerAdapter进行多次扩展。
// *
// * Created by Administrator on 2018/9/10 0010.
// */
//@EnableWebSecurity
//public class MultiHttpSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    /**
//     * 配置正常的验证
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("USER","ADMIN");
//    }
//
//    @Configuration
////    @Order(1)//表示优先配置
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            http.antMatcher("/api/**")
//                    .authorizeRequests()
//                    .anyRequest().hasRole("ADMIN")
//                    .and()
//                    .httpBasic();
//        }
//
//    }
//
//    //没有指定@Order默认会被放到最后
//    @Configuration
//    public static class FormLoginWebSecutiryConfigurerAdapter extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .formLogin();
//        }
//    }
//
//
//
//}
