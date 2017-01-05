package com.frt.spring.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;

	 @Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth.jdbcAuthentication().dataSource(dataSource)
		 .usersByUsernameQuery(
				   "select username,password, enabled from user where username=?")
				  .authoritiesByUsernameQuery(
				   "select us.username, ur.role from user us, user_role ur where "
				   + "us.id = ur.user_id and us.username =?");	 
		 System.out.println("In authentication");
		 
	}
	
	 protected void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests()
		  .antMatchers("/").access("hasRole('ROLE_USER')")  
		  .anyRequest().permitAll()
		  .and()
		    .formLogin().loginPage("/login").permitAll().loginProcessingUrl("/j_spring_security_check")
		    .usernameParameter("j_username").passwordParameter("j_password")
		  .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?logout").and()		   
		   /*.exceptionHandling().accessDeniedPage("/403")
		  .and()*/
		    .csrf().disable();
		 }

}
