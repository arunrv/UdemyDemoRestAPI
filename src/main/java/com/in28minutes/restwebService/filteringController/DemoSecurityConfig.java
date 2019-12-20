package com.in28minutes.restwebService.filteringController;

/*import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;*/

/*@Configuration
@EnableWebSecurity // this will enable the web security for your application
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		//UserDetails is the inbuilt class in the spring framework security.
		
		List<UserDetails> users=new ArrayList<UserDetails>();
		users.add(User.withDefaultPasswordEncoder().username("Naveen").password("1234").roles("USER").build());//this will create the session
		//we are having lot of roles that we can define. Time beeing just use as user
		//SINCE we dont have the data base we will use InMemoryDataBaseUserDetail manager. This is a class we have to use.
		InMemoryUserDetailsManager user1 = new InMemoryUserDetailsManager(users);
		return user1;
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
	}*/
	
	
	
//}*/






