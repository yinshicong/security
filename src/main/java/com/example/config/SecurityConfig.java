package com.example.config;

import com.example.filter.AfterFilter;
import com.example.filter.IBeforeFilter;
import com.example.filter.MyFilter;
import com.example.repository.IUserRepository;
import com.example.service.IMongoUserService;
import com.example.util.PwdEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
@EnableWebSecurity
//注解会启用web安全功能。但是它本身并没有什么用处，spring security必须配置在一个实现了webSecuritConfigurer的bean中，或者扩展WebSecurityConfigurerAdapter。
public class SecurityConfig extends WebSecurityConfigurerAdapter{


        @Autowired
        private IUserRepository userRepository;
        @Autowired
        private DataSource dataSource;
        @Autowired
        private MyFilter myFilters;
        @Autowired
        private IBeforeFilter beforeFilters;
        @Autowired
        private AfterFilter afterFilters;
        @Autowired
        private AdminAccessDeniedHandler adminAccessDeniedHandler;
        @Autowired
        private PwdEncoder pwdEncoder;
        @Autowired
        private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
        @Autowired
        private IMongoUserService mongoUserService;

        /**
         *
         * 通过重载，配置user-detail服务
         *
         * @param auth
         * @throws Exception
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("USER","ADMIN");

            //基于jdbc进行访问。
//        auth.jdbcAuthentication()
//                .dataSource(null);

            /**
             * LDAP目录以树状的层次结构来存储数据。如果你对自顶向下的DNS树或UNIX文件的目录树比较熟悉，也就很容易掌握LDAP目录树这个概念了。就象DNS的主机名那样，LDAP目录记录的标识名（Distinguished Name，简称DN）是用来读取单个记录，以及回溯到树的顶部。后面会做详细地介绍。
             */
            //基于ldap进行访问。

            //基于内存的用户账号nMemoryAuthentication方法启用，配置并任意填充基于内存的用户存储。
            /**
             * roles()方法是authorities()方法的简写形式。roles()方法所给定的值都会添加一个“ROLE_”前缀，并将其作为权限
             授予给用户
             */
//        auth.inMemoryAuthentication()
//                .passwordEncoder(pwdEncoder)
//                .withUser("user").password("password").roles("USER")
//                .and().withUser("admin").password("password").roles("ADMIN");

//        auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(pwdEncoder)
//                .usersByUsernameQuery("" +
//                        "SELECT name,password,true FROM t_user WHERE name = ?")
//                .authoritiesByUsernameQuery("" +
//                        "SELECT name,password,'ROLE_ADMIN' FROM t_user WHERE name = ?");

            /**
             * 配置自定义用户来源
             */
            auth.userDetailsService(mongoUserService);


        }

        /**
         *
         * 通过重载，配置如何通过拦截器保护请求
         *
         * HttpSecurity方法表如下所示:
         * https://my.oschina.net/liuyuantao/blog/1922347
         *
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            /**
             * 这些规则会按照给定的顺序发挥作用。所以，很重要的一点就是将最为具体的请求路径放在前面，而最不具体的路径
             （如anyRequest()）放在最后面。如果不这样做的话，那不具体的路径配置将会覆盖掉更为具体的路径配置。
             */
            http
//                addFilter(myFilters)
//                .addFilterBefore(myFilters, BeforeFilter.class)
//                .addFilterAfter(myFilters,AfterFilter.class)
                    .exceptionHandling()
                    .accessDeniedHandler(adminAccessDeniedHandler)//访问失败才会进入
                    .and()

                    .authorizeRequests()
                    .antMatchers("/api/**")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/admin/**")
                    .hasRole("ADMIN")
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
                    .failureHandler(myAuthenticationFailureHandler)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/user/**").access("hasRole('ROLE_USER')")

//                    .authenticated()//表示user下的所有路径都必须登录才能进入；
                    .and()
                    .authorizeRequests()
                    .antMatchers("/**")//最模糊的要放到最后
                    .permitAll();

        }

        /**
         * 通过重载，配置Spring Security的Filter链
         * @param web
         * @throws Exception
         */
        @Override
        public void configure(WebSecurity web) throws Exception {
        }


//    @Order(90)
//    @Configuration
//    public static class UserSecurityConfig extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
////            auth.inMemoryAuthentication()
////                    .passwordEncoder(new PwdEncoder())
////                    .withUser("user")
////                    .password("user");
//
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.
//            formLogin()
//            .loginProcessingUrl("login")
//            .and()
//            .authorizeRequests()
//            .antMatchers("/user/**")
//            .authenticated();//表示user下的所有路径都必须登录才能进入；
//        }
//
//    }


}
