package com.io.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthentication customAuthentication;

	@Bean
	public UserDetailsService userDetailsService() {
		// IMplementation Of In Memory Database Authentication

		InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();
		UserDetails user1 = User.withUsername("JoeRO").password("Joe123").authorities("read").build();
		uds.createUser(user1);
		return uds;

		// return new UserDetailsServiceImpl();

	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return NoOpPasswordEncoder.getInstance();
		// return new BCryptPasswordEncoder();
	}

	public void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(customAuthentication);
	}

}
