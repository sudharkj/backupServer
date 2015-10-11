package com.jsrk.backup.server.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.jsrk.backup.server.data.service.UserService;
import com.jsrk.backup.server.model.User;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = (String) auth.getPrincipal();
		String password = (String) auth.getCredentials();
		User user = userService.loadUserByUsername(username);

		if (user == null || !user.getPassword().equals(password)) {
			throw new BadCredentialsException("Invalid username or password");
		}

		// Associate "ROLE_USER" role with all users
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(
				"ROLE_USER");
		grantedAuthorities.add(grantedAuthority);

		return new UsernamePasswordAuthenticationToken(user, password,
				grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
