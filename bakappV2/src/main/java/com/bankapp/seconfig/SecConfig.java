package com.bankapp.seconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/accountops/**").hasAnyRole("MGR")
		.antMatchers("/transaction/**").hasAnyRole("CLERK","MGR")
		.antMatchers("/home/**").permitAll()
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/banklogin")
		.usernameParameter("cName").passwordParameter("cPass")
		.defaultSuccessUrl("/home")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
