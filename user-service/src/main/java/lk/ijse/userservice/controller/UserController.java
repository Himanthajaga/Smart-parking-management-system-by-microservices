package lk.ijse.userservice.controller;

import lk.ijse.userservice.entity.AppUser;
import lk.ijse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return service.register(user);
    }

    @PutMapping("/{id}")
    public AppUser update(@PathVariable Long id, @RequestBody AppUser updated) {
        return service.update(id, updated);
    }

    @GetMapping("/{id}")
    public AppUser get(@PathVariable Long id) {
        return service.repo.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<AppUser> all() {
        return service.repo.findAll();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.repo.deleteById(id);
        return "User deleted successfully.";
    }
@PostMapping("/update/{id}")
    public AppUser updateUser(@PathVariable Long id, @RequestBody AppUser updated) {
        return service.update(id, updated);
    }
    @GetMapping("/username/{username}")
    public AppUser findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

}
