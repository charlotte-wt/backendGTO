package com.example.gto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtoApplication.class, args);
	}

	

}

@RestController
class HelloControLler {

  @RequestMapping("/")
  public String hello() {
    return "Hello Spring Boot";
  }

}
