package com.woho.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
	private AuthenticationProvider authenticationProvider;*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest()
			.permitAll()
			.and().csrf().disable();
	}

}
