package gr.aschoinas.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"gr.aschoinas"})
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
