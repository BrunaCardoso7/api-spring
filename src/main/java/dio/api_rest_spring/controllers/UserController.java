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
    @PatchMapping("/users/{id}")
    public User updateUser (@PathVariable("id") Integer id, @RequestBody User user){
        Optional<User> foundUserOptional = repository.findById(id);

        if (foundUserOptional.isPresent()) {
            User foundUser = foundUserOptional.get();

            foundUser.setName(user.getName());
            foundUser.setEmail(user.getEmail());
            foundUser.setPassword(user.getPassword());

            return repository.save(foundUser);
        }
        return user;
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
