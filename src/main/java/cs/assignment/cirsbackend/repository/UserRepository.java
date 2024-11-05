package cs.assignment.cirsbackend.repository;

import cs.assignment.cirsbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findOneByEmailAndPassword(String email, String password);
    Users findByEmail(String email);

    // You can add custom query methods here if needed
}