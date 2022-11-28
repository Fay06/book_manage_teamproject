package com.nobug.nobug_teamproject;

import com.nobug.nobug_teamproject.security.JWTAuthorizationFilter;
import com.nobug.nobug_teamproject.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        private final ClientService clientService;
        public WebSecurityConfig(ClientService clientService)
        {
            this.clientService = clientService;
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(clientService), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .anyRequest().authenticated();
        }
    }

}
