package com.group5.MiniSurveyMonkey.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DBUserDetailsService dbUserDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/surveyorIndex/**").hasRole("ADMIN")
                .antMatchers("/userIndex/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2/**")
                .antMatchers("/resources/**")
                .antMatchers("/images/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(dbUserDetailsService);
        auth.inMemoryAuthentication().withUser("surveyor")
                .password(getPasswordEncoder().encode("surveyor")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("john")
                .password(getPasswordEncoder().encode("pass")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("kashish")
                .password(getPasswordEncoder().encode("pass")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("vis")
                .password(getPasswordEncoder().encode("pass")).roles("ADMIN");

        auth.inMemoryAuthentication().withUser("user")
                .password(getPasswordEncoder().encode("user")).roles("USER");
    }
}
