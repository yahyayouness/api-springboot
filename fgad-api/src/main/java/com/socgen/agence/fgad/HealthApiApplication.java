package com.socgen.agence.fgad;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableConfigurationProperties
@Controller
public class HealthApiApplication {

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Metrics");
		model.put("title", "Health");
		model.put("date", new Date());
		return "home";
	}

	public static void main(String[] args) {
		SpringApplication.run(HealthApiApplication.class, args);
	}

}
