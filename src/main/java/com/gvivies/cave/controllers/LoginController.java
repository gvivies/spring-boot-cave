package com.gvivies.cave.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.CaveAuthenticationProvider;
import com.gvivies.cave.model.AppAuthentication;
import com.gvivies.cave.model.User;
import com.gvivies.cave.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CaveAuthenticationProvider authentProvider;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public User login(@RequestHeader(value = "authorization") String auth, HttpServletRequest request) {

		User authenticated = null;
		try {

			User user = userService.retrieveUserFromAuthentication(auth);
			authenticated = userService.getLoggedInUser(user);
			
			if (authenticated.getRole() != null) {
				Collection<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority(authenticated.getRole().getId()));
				
				//UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				//		authenticated.getUsername(), authenticated.getPassword(), grantedAuths);
				// Special authentication that keep Id (used to filter ownedBy data)
				AppAuthentication token = new AppAuthentication(
								authenticated.getUsername(), authenticated.getPassword(), grantedAuths);
				token.setDetails(new WebAuthenticationDetails(request));
				token.setId(authenticated.getId());
				Authentication authentication = authentProvider.authenticate(token);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);				
			} else {
				SecurityContextHolder.getContext().setAuthentication(null);
			}		

		} catch (Exception e) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		authenticated.setPassword(null);
		return authenticated;
	}

}
