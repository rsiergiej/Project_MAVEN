package com.dataInitial;


import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);



   // @Autowired private PersonRepository personRepository;

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

//            log.info("-------------------------------");
//            for (Person customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//           System.err.println(repository.findByName("Bauer"));


        };
    }
}
