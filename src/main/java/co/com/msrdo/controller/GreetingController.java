package co.com.msrdo.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.msrdo.model.Greeting;

@RestController
public class GreetingController {
	
	private static final String TEMPLATE = "HELLO, %s!";
	
	@RequestMapping("/greeting/{name}")
    public HttpEntity<Greeting> greeting(
    		@PathVariable("name") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        //greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
	
	@RequestMapping("/")
	public HttpEntity<String> greeting1() {

        return new ResponseEntity<String>("Hola", HttpStatus.OK);
    }

	

}
