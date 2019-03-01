package com;//ZADANIE
/*
Zrób sobie coś takiego
Pobranie listy produktów
Pobranie szczegółów produktu
Dodanie produktu
Usunięcie produktu

Możesz poszukać biblioteki
spring boot data
 I bazę h2
 https://dzone.com/articles/integrate-h2-database-in-your-spring-boot-applicat?fbclid=IwAR3F5fPptR1aFe4i0T3hPFcIBqkDzMtSBddRvU3uUg0AMYCZ_g94EbqG810

http://localhost:8080/h2/

https://dzone.com/articles/integrate-h2-database-in-your-spring-boot-applicat?fbclid=IwAR3F5fPptR1aFe4i0T3hPFcIBqkDzMtSBddRvU3uUg0AMYCZ_g94EbqG810


Teraz zrób interfejs
Który rozszerza JpaRepository
A później możesz robić save do bazy
 */

import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class MainSpringBootApplicaton {


	private static final Logger log = LoggerFactory.getLogger(MainSpringBootApplicaton.class);

	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootApplicaton.class, args);

	}




	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			repository.save(new Person("Radek"));
			repository.save(new Person("Michal"));
			repository.save(new Person("Paweł"));
			repository.save(new Person("Tomek"));
			repository.save(new Person("Mateusz"));

			log.info("-------------------------------");
			for (Person customer : repository.findAll()) {
				log.info(customer.toString());
			}
			System.err.println(repository.findByName("Bauer"));


		};
	}




}
