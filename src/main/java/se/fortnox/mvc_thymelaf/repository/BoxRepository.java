package se.fortnox.mvc_thymelaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.fortnox.mvc_thymelaf.entity.Box;

import java.util.Optional;


public interface BoxRepository extends CrudRepository<Box,Integer> {
    Optional<Box> findByEmail(String email);
}
