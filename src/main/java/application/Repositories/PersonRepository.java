package application.Repositories;



import application.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String personName);
    Optional<Person> findById(Long id);
    Person findByid(Long id);
   // Page<Person> findPaginated(int page, int size);
  // Page<Person> findPaginated(String type, Pageable pageable);
    Page<Person> findByType(String type, Pageable pageable);
}
