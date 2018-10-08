package com.rdops.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Users {

	@GetMapping("/me")
	public Principal currentUser(Principal principal) {
		return principal;
	}

}
