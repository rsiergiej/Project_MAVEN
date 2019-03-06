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

// https://o7planning.org/en/11893/integrating-spring-boot-jpa-and-h2-database

// INFO http://www.trainingbangalore.in/blog/java-interview-questions-answers-part3/
Teraz zrób interfejs
Który rozszerza JpaRepository
A później możesz robić save do bazy
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


@SpringBootApplication
//@EnableJpaAuditing // co to jest??

//@Value("${my.property}")
//private String value;


public class MainSpringBootApplicaton
{




	static Connection con = null;

	static String URL = "jdbc:h2:file:~/test";
	static String USER = "sa";
	static String PASSWORD = "";


	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootApplicaton.class, args);




		Properties prop = new Properties();
		InputStream inputStream = MainSpringBootApplicaton.class.getClassLoader().getResourceAsStream("application.properties");

		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.toString());

		System.out.println(prop.getProperty("spring.datasource.url"));
		try
		{
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}






//		 Connection con = null;
//		try {
//			con = DriverManager.getConnection("jdbc:h2:file:~/test", "sa", "");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		Statement st = null;
//		try {
//			st = con.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM person");
//			ResultSetMetaData md = rs.getMetaData();
//			int col = md.getColumnCount();
//			System.out.println("Number of Column : "+ col);
//			System.out.println("Columns Name: ");
//			for (int i = 1; i <= col; i++) {
//				String col_name = md.getColumnName(i);
//				System.out.println(col_name);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}




















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
