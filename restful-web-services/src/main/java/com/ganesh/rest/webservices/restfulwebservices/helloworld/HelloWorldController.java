package com.ganesh.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("Hello World");
//		throw new RuntimeException(" HelloWorldController  RuntimeException");
	}

	@GetMapping(path = "/hello-world-bean/{name}")
	public AuthenticationBean helloWorldBean(@PathVariable String name) {
		return new AuthenticationBean(String.format("Hello World %s", name));
//		throw new RuntimeException(" HelloWorldController  RuntimeException");
	}

}
