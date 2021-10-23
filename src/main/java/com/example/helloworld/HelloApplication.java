package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}

@RestController
class Hello {

    @RequestMapping("/")
    String index() {
        return "Hello world";
    }

	@RequestMapping("/spring")
    String spring() {
        return "<h1 style='color:red;'>Welcome to Spring Boot</h1> ";
    }

	@GetMapping("/data/{id}")
	String data(@PathVariable Long id) {
		long ids = id;
		return "<h1>We received ID as "+ String.valueOf(ids)+"</h1>";
	}

	@GetMapping("/calc/{a}/plus/{b}")
	String add(@PathVariable Long a, @PathVariable Long b) {
		long ids = a + b;
		return "<h1>Addition "+ String.valueOf(ids)+"</h1>";
	}

	@GetMapping("/calc/{a}/minus/{b}")
	String minus(@PathVariable Long a, @PathVariable Long b) {
		long ids = a - b;
		return "<h1>Subtraction "+ String.valueOf(ids)+"</h1>";
	}

	@GetMapping("/calc/{a}/multi/{b}")
	String multi(@PathVariable Long a, @PathVariable Long b) {
		long ids = a * b;
		return "<h1>Multiplication "+ String.valueOf(ids)+"</h1>";
	}

	@GetMapping("/calc/{a}/div/{b}")
	String div(@PathVariable Long a, @PathVariable Long b) {
		if (b == 0){
			return "<h1>Infinite</h1>"
		}
		long ids = a / b;
		return "<h1>Division "+ String.valueOf(ids)+"</h1>";
	}
}
