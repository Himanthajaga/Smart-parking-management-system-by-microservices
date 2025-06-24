package lk.ijse.userservice.repository;

import lk.ijse.userservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsernameAndEmail(String username, String email);
    Optional<AppUser> findByUsernameAndEmailAndRole(String username, String email, String role);
    Optional<AppUser> findByEmailAndRole(String email, String role);
    Optional<AppUser> findByUsernameAndRole(String username, String role);
}
