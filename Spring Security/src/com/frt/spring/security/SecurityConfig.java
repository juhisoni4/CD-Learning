package com.frt.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//@Configuration
//@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 DataSource dataSource;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth.jdbcAuthentication().dataSource(dataSource)
		 .usersByUsernameQuery(
				   "select username,password, enabled from users where username=?")
				  .authoritiesByUsernameQuery(
				   "select us.username, ur.role from user us, user_roles ur where "
				   + "us.id = ur.user_id and us.username =?");	 
		 System.out.println("In authentication");
		 
	}
	
	 protected void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests()
		  .antMatchers("/").access("hasRole('ROLE_USER')")  
		  .anyRequest().permitAll()
		  .and()
		    .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
		    .usernameParameter("username").passwordParameter("password")
		  .and()
		    .logout().logoutSuccessUrl("/login?logout") 
		   .and()
		   .exceptionHandling().accessDeniedPage("/403")
		  .and()
		    .csrf();
		 }
}
