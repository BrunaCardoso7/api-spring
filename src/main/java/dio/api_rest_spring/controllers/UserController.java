package dio.api_rest_spring.controllers;

import dio.api_rest_spring.models.User;
import dio.api_rest_spring.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getUser () {
        return repository.findAll();
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
