package pe.edu.upc.clientsboot.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.clientsboot.domain.entities.Client;

import java.util.UUID;

@Repository
public interface ClientRepository<T extends Client> extends JpaRepository<T, UUID> {
}
