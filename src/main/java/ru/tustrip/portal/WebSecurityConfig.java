package ru.tustrip.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.tustrip.portal.service.security.CustomAuthenticationSuccessHandler;
import ru.tustrip.portal.service.security.RepositoryUserDetailsService;

/**
 * Created by antonorlov on 22/05/16.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/agent_interface/**").access("hasRole('ROLE_AGENT')")
//                .anyRequest().authenticated()
//                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                        .successHandler(getSuccessHandler())
//                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService());
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("ADMIN");
    }

    /**
     * This bean is load the user specific data when form login is used.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new RepositoryUserDetailsService();
    }


    @Bean
    public AuthenticationSuccessHandler getSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }
}