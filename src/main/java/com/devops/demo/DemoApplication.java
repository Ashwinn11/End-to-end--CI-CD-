package com.devops.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/path")
public class DemoApplication {

	@GetMapping("/")
	public String index(final Model model) {
		model.addAttribute("title", "I have successfully built a spring boot application using Maven");
		model.addAttribute("msg", "This application is deployed on to Kubernetes using Argo CD");
		return "index";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
