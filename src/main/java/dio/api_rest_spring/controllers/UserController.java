package dio.api_rest_spring.controllers;

import dio.api_rest_spring.models.User;
import dio.api_rest_spring.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getUser () {
        return repository.findAll();
    }

    @PostMapping("/users")
    public User createUser (@RequestBody User user){
        return  repository.save(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserByUsername (@PathVariable("id")Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById (@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
}
