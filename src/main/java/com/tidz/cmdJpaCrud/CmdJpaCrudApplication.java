package com.tidz.cmdJpaCrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CmdJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmdJpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(String[] args) {
		return runner -> {
			System.out.println("Hello Command Line Runner");
		};
	}

}
