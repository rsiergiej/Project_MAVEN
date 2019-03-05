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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.awt.Label;


@SpringBootApplication
@EnableJpaAuditing // co to jest??
public class MainSpringBootApplicaton
{




	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootApplicaton.class, args);


//		try {
//			Class cls = Class.forName("com.Entity.Person");
//			System.out.println("Fields =");
//
//			// returns the array of Field objects representing the public fields
//			Field f[] = cls.getDeclaredFields();
//			for (int i = 0; i < f.length; i++) {
//				System.out.println(f[i].getName());
//			}
//		} catch (Exception e) {
//			System.out.println("Exception: " + e);
//		}



	}









}
