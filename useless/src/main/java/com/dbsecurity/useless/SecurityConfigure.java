package com.dbsecurity.useless;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;





@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("user")
				.password("oooo")
				.roles("USER"))
					
		
	.withUser(
			User.withUsername("admin")
			.password("pass")
			.roles("ADMIN")
			);
			}	
	
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("admin").hasRole("ADMIN")
			.antMatchers("users").hasAnyRole("ADMIN","USER")
			.antMatchers("/").permitAll().and().formLogin();
			}
		
		
		
		@Bean
		PasswordEncoder  getPasswordEncoder()
		 {
			 return NoOpPasswordEncoder.getInstance();
		 }
	}
	
	
	


