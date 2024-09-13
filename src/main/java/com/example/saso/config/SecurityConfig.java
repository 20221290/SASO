package com.example.saso.config;

import com.example.saso.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//自定义security配置
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    /**
     * 配置HTTP请求的安全性规则，禁用CSRF保护，设置会话管理策略为无状态，并指定某些路径可以匿名访问，其他路径需要进行身份验证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用CSRF（跨站请求伪造）保护，因为在无状态的JWT认证中，不需要使用CSRF保护。
        http.csrf().disable()
                //设置会话管理策略为无状态，即不创建和使用会话。
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //开始配置请求的授权规则
                .authorizeRequests()
                //指定/user/login路径可以匿名访问，即不需要身份验证
//                .antMatchers("/user/login").anonymous()
                .antMatchers("/**").permitAll()
                //指定其他所有请求都需要进行身份验证。
                .anyRequest().authenticated();

        //把token校验过滤器添加到过滤器链中
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //开启跨域请求
        http.cors();
    }

    @Bean
    /**
     * 获取AuthenticationManager对象，以便在其他地方使用该对象进行身份验证
     * @return
     * @throws Exception
     */
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        //调用super.authenticationManagerBean()方法，该方法是WebSecurityConfigurerAdapter类中的一个方法，用于获取AuthenticationManager对象。
        return super.authenticationManagerBean();
    }


}
