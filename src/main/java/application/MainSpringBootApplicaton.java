package application;/*
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


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableJpaAuditing // co to jest??


public class MainSpringBootApplicaton
{




	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootApplicaton.class, args);





/* -----------Pobranie danych z properties-----------
		Properties prop = new Properties();
		InputStream inputStream = MainSpringBootApplicaton.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.toString());

		System.out.println(prop.getProperty("spring.datasource.url"));
 */



/* -----------Połączenie z bazą i odbiór listy kolumn z tabeli-----------
		 Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:file:~/test", "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM person");
			ResultSetMetaData md = rs.getMetaData();
			int col = md.getColumnCount();
			System.out.println("Number of Column : "+ col);
			System.out.println("Columns Name: ");
			for (int i = 1; i <= col; i++) {
				String col_name = md.getColumnName(i);
				System.out.println(col_name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
 */




/* ----------- Pobranie wszystkid pól z klasy Person-----------
		try {
			Class cls = Class.forName("com.Entity.Person");
			System.out.println("Fields =");

			// returns the array of Field objects representing the public fields
			Field f[] = cls.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(f[i].getName());
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
 */





	}









}


/* informacja o STREAM

O Stream
Klasa Stream
I np w listach
Masz metodę stream
Np List dupa = New Arrsylist()
dupa.stream().ITuCosRobisz
Ogarnij
Cos takiego jak :
Consumer
Producer
Function
BiFunction
Stream
Optional
Tak w telegraficznym skrócie
Consumer to wsadzasz do niego coś i nic nie zwraca czyli coś w stylu
void funkcja(String dupa)
Producer nie przyjmuje nic Ale coś zwraca czyli
Coś funkcja()
I zwracasz Coś
Function przyjmuje typ jakiś A zwraca inny czyli
Typ1 Funkcja (Typ2 argument)
Przyjmuje typ2 A zwraca typ1
Np
A biFunction to to samo Tylko że przyjmujesz 2 różne typy i zwracasz 1 inny
I to Ci wystarczy

Ogarnij kilka metod z klasy Stream
filter
map
Foreach
Te na poczatek
Metody z Optional to
orElseGet()
orElseThrow()
I narazie to na początek się naucz
A w sumie jak to zrozumiesz to zrozumiesz resztę
Te są najbardziej intuicyjne
I najlepiej się na nich uczy
I są najczęściej używane
Aha i ważne żebyś wiedział że streamy są lazy
Czyli czasami mogą Ci nie zwrócić wyniku
Musisz wywołać na nich kolektor jakiś
Typu forEach
 */