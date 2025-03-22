package ir.benji.benjfa_oauth_service.user.repository;

import ir.benji.benjfa_oauth_service.user.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByUsername(String username);

    Optional<Person> findByPhone(String phone);

    long countByEmailOrPhone(String email,String phone);
    boolean existsByEmail(String email);
}
