package com.in28mins.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloworldController1 {
	private final GreetingService service;
	
	@RequestMapping(value = "/helloword")
	public String hello()
	{
		return "Hello World";
	}


	public HelloworldController1(GreetingService service) {
		this.service = service;
	}

	@RequestMapping(value = "/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}
