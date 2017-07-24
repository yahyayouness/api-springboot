package com.socgen.agence.fgad.mongo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.socgen.agence.fgad.dao.UserRepository;
import com.socgen.agence.fgad.entity.User;

@RunWith(SpringRunner.class)
@DataMongoTest
//@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class TestUserDao {

	@Autowired
	private UserRepository repository;

	// Cas droit d'insertion d'un utilisateur : nom yahya
	private static final String JDD1_USER_NAME = "SLIM";
	private static final String JDD2_USER_NAME = "TOUFIK";

	@Test
	public void testSave() {

		repository.deleteAll();

		// save a couple of Users
		repository.save(new User(JDD1_USER_NAME, "yahya"));
		repository.save(new User(JDD2_USER_NAME, "Dupitier"));

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
		final User resultYahya = repository.findByFirstName(TestUserDao.JDD1_USER_NAME);
		System.out.println(resultYahya);

		assertEquals(JDD1_USER_NAME, resultYahya.firstName);

		System.out.println("Users found with findByLastName('Dupitier'):");
		System.out.println("--------------------------------");
		for (User User : repository.findByLastName(JDD2_USER_NAME)) {
			System.out.println(User);
		}

		final User resultMathiew = repository.findByFirstName(JDD2_USER_NAME);
		assertEquals(JDD2_USER_NAME, resultMathiew.firstName);

	}

	@Test
	public void testRead() {

		repository.deleteAll();

		// save a couple of Users
		repository.save(new User(JDD1_USER_NAME, "yahya"));
		repository.save(new User(JDD2_USER_NAME, "Dupitier"));

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
		final User resultYahya = repository.findByFirstName(TestUserDao.JDD1_USER_NAME);
		System.out.println(resultYahya);

		assertEquals(JDD1_USER_NAME, resultYahya.firstName);

		System.out.println("Users found with findByLastName('Dupitier'):");
		System.out.println("--------------------------------");
		for (User User : repository.findByLastName(JDD2_USER_NAME)) {
			System.out.println(User);
		}

		final User resultMathiew = repository.findByFirstName(JDD2_USER_NAME);
		assertEquals(JDD2_USER_NAME, resultMathiew.firstName);

	}

	//
}
