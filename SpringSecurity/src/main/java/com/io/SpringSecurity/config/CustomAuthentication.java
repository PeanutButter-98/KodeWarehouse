package com.io.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthentication implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder pwdencoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Here the Logic of how authentication is gonna implement

		// If the Required AUthenticationProvider is matched then it will return null.
		// If the Authentication succeeds the authentication onject instance will be
		// returned.
		// if Authentication fails to match the validate it will throw
		// authenticationException

		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		UserDetails u = userDetailsService.loadUserByUsername(username);

		if (u != null) {
			if (pwdencoder.matches(password, u.getPassword())) {
				UsernamePasswordAuthenticationToken utoken = new UsernamePasswordAuthenticationToken(username, password,
						u.getAuthorities());
				return utoken;
			}
		}

		throw new BadCredentialsException("Credintials Error!");
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
