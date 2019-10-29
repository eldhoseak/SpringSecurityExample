package com.spring.sec;

import com.spring.sec.service.PersonUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * This class contains the configurations for 2 authentication tyopes in Spring.
 * In memory authentication - to test it uncomment the methos from line 48
 * Jdbc authentication- to test comment, in memry auth configuration and uncomment
 * code from line 59.
 */


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PersonUserDetailsService personUserDetailsService;

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // All requests send to the Web Server request must be authenticated
        http.authorizeRequests().anyRequest().authenticated();

        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);
    }


    // Create 2 users for In memory authentication
    //@Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }



// Below is required for JDBC authentication.
/*@Bean
   public DaoAuthenticationProvider authententicationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(personUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
return daoAuthenticationProvider;
}

protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.authenticationProvider(authententicationProvider());
}*/

}