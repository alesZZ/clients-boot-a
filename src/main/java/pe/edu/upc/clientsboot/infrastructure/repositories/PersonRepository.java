package pe.edu.upc.clientsboot.infrastructure.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upc.clientsboot.domain.entities.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends ClientRepository<Person> {
    Optional<Person> findByDniValue(String dni);
}