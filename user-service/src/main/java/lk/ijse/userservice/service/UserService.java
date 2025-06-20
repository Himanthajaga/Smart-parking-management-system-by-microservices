package lk.ijse.userservice.service;

import lk.ijse.userservice.entity.AppUser;
import lk.ijse.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepository repo;

    public AppUser register(AppUser user) {
        return repo.save(user);
    }

    public AppUser update(Long id, AppUser updated) {
        AppUser user = repo.findById(id).orElseThrow();
        user.setEmail(updated.getEmail());
        user.setRole(updated.getRole());
        return repo.save(user);
    }
    public AppUser findByUsername(String username) {
        return repo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
