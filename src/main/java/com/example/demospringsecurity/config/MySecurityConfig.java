package com.example.demospringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			//csrf is an attack sprig security prevent us
//			.csrf().disable() 
			.authorizeRequests() //req authrize karvani
//			.antMatchers(HttpMethod.GET,"/public/**").permitAll()
			.antMatchers("/public/**").hasRole("NORMAL")
			.antMatchers("/users/**").hasRole("ADMIN")
			.antMatchers("/signin").permitAll()
			.anyRequest() //koi pn request
			.authenticated() //permission access krvani e pehla authenticate hovi joie
			.and()
//			.httpBasic();
			.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/users/");
		
	}
	
	//creating user with pwd and role
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("harsh")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("ajay").password(this.passwordEncoder().encode("ajay")).roles("ADMIN");
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	
//	@Override
//	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("john").password("harsh").roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("ajay").password("ajay").roles("ADMIN");
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
}
