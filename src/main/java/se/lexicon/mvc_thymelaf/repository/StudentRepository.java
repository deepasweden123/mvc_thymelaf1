package se.lexicon.mvc_thymelaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mvc_thymelaf.entity.Student;

import java.util.Optional;


public interface StudentRepository extends CrudRepository<Student,Integer> {
    Optional<Student> findByEmail(String email);
}
