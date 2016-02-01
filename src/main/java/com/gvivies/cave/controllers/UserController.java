package com.gvivies.cave.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.User;
import com.gvivies.cave.services.UserService;

@RestController
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value={"/user"}, method = RequestMethod.GET)
	public Principal user(@AuthenticationPrincipal Principal user) {
		return new Principal() {		
			@Override
			public String getName() {
				return "gvivies";
			}
		};
	}

    @RequestMapping(value={"/users"}, method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }


}
