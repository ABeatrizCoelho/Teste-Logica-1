package com.estagio.exer01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estagio.exer01.principal.Principal;

@SpringBootApplication
public class Exer01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Exer01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

	}

}
