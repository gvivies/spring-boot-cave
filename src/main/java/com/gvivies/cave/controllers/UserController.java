package com.gvivies.cave.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.CaveAuthenticationProvider;
import com.gvivies.cave.dto.UserRole;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.User;
import com.gvivies.cave.services.UserService;

@RestController
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public Collection<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = { "/users" }, method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return userService.insertAndInitData(user);
	}

	@RequestMapping(value = { "/users" }, method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = { "/users/roles" }, method = RequestMethod.GET)
	public List<UserRole> getUserRoles() {
		return userService.getUserRoles();
	}
	
	@RequestMapping(value = { "/users/{id}" }, method= RequestMethod.DELETE)
	  public void delete(@PathVariable String id) {
		User user = userService.findOne(id);
		if (user!= null) {
			userService.delete(user);
		}	 
	}

}
