package application.Repositories;



import application.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String personName);
    Optional<Person> findById(Long id);
    Person findByid(Long id);


}
