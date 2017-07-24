package com.socgen.agence.fgad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socgen.agence.fgad.entity.User;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of Users
		repository.save(new User("yahya", "youness"));
		repository.save(new User("Mathieu", "Dupitier"));

		// fetch all Users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User User : repository.findAll()) {
			System.out.println(User);
		}
		System.out.println();

		// fetch an individual User
		System.out.println("User found with findByFirstName('yahya'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("yahya"));

		System.out.println("Users found with findByLastName('Dupitier'):");
		System.out.println("--------------------------------");
		for (User User : repository.findByLastName("Dupitier")) {
			System.out.println(User);
		}

	}

}
