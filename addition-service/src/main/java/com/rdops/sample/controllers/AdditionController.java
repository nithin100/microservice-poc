package com.rdops.sample.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdditionController {

	@PostMapping("/add/{num1}/{num2}")
	public int doAddition(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		return num1 + num2;
	}

}
