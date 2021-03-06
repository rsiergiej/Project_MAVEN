package application.dataInitial;

import application.Repositories.UserRepository;
import application.model.Person;
import application.Repositories.PersonRepository;
import application.model.User;
import application.security.AES;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);






    @Bean
    public CommandLineRunner demo2(UserRepository userRepository)
    {
        AES aescrypt = new AES();

        try {
            userRepository.save(new User("login", "login", aescrypt.encrypt("login"), "login@wp.pl"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return(arg) ->{
            userRepository.save(new User("r.s", "radek", aescrypt.encrypt("passwordrad"), "rad@wp.pl"));
            userRepository.save(new User("m.k", "michal",aescrypt.encrypt("passwordMICH"), "mich@wp.pl"));
        };
    }


    @Bean
    public CommandLineRunner demo(PersonRepository repository) {


        Person test = new Person("Stasiek");


        return (args) -> { // zapis do bazy
            repository.save(new Person("Radek", "test"));
            repository.save(new Person("Michal"));
            repository.save(new Person("Paweł"));
            repository.save(new Person("Tomek"));
            repository.save(new Person("Mateusz"));
            repository.save(test);
            repository.save(new Person("Bartek"));
            repository.save(new Person("Paweł"));
            repository.save(new Person("Radek"));
            repository.save(new Person("Kasia"));
            repository.save(new Person("Paulina"));
            repository.save(new Person("Java"));
            repository.save(new Person("Ewelina"));
            repository.save(new Person("Ania"));
            repository.save(new Person("Jan", "moje dane"));
            repository.save(new Person("Jacek"));
            repository.save(new Person("Grzegorz"));
            repository.save(new Person("Radosław"));
            repository.save(new Person("Iwona"));
            repository.save(new Person("Michał"));




//            log.info("-------------------------------");
//            for (Person customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//           System.err.println(repository.findByName("Bauer"));


        };
    }
}
