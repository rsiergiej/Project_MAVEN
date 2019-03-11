package application;/*
Zrób sobie coś takiego
Pobranie listy produktów - ok
Pobranie szczegółów produktu - ok
Dodanie produktu - ok
Usunięcie produktu - ok



Sortowanie listy - ok
paginacja - ok



logowanie
formularze

jak wykona się poprawnie to zwarcam 200
jezeli wyjatek to 500


thymeleafem  lub JSP  - frontend





Informacja o STREAM O Stream Klasa Stream I np w listach Masz metodę stream Np List test = New Arrsylist() test.stream().ITuCosRobisz

Co to jest :
Consumer - wsadzam do niego coś i nic nie zwraca czyli coś w stylu void funkcja(String text)
Producer - nie przyjmuje nic ale coś zwraca czyli String funkcja()
Function - przyjmuje typ A zwraca inny czyli Typ1 funkcja(Typ2 arg)
BiFunction - to samo co Function czyli przyjmuje 2 róźne typy i zwraca 1 inny
Stream
Optional


Kilka metod z klasy Stream:
filter
map
Foreach
Te na poczatek

Metody z Optional:
orElseGet()
orElseThrow()

Narazie to na początek się naucz, a w sumie jak to zrozumiesz to zrozumiesz resztę
Te są najbardziej intuicyjne i najlepiej się na nich uczy i są najczęściej używane
Ważne żebyś wiedział że streamy są lazy - Czyli czasami mogą Ci nie zwrócić wyniku Musisz wywołać na nich kolektor jakiś Typu forEach



// INFO http://www.trainingbangalore.in/blog/java-interview-questions-answers-part3/


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


