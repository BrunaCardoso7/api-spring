package dio.api_rest_spring.controllers;

import dio.api_rest_spring.handdlers.BusinessExceptions;
import dio.api_rest_spring.handdlers.RequiredFieldsException;
import dio.api_rest_spring.models.User;
import dio.api_rest_spring.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<?> getUser () {
        try {
            User users = (User) repository.findAll();
            return ResponseEntity.status(200).body(users);
        } catch (BusinessExceptions businessExceptions) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessExceptions.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser (@RequestBody User user){
        try {
            if (user.getName() == null)
                throw new RequiredFieldsException("name");
            if (user.getEmail() == null)
                throw new RequiredFieldsException("email");
            if (user.getPassword() == null)
                throw new RequiredFieldsException("password");

            User usercreated =  repository.save(user);
            return ResponseEntity.status(200).body(usercreated);
        } catch (BusinessExceptions businessExceptions) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessExceptions.getMessage());
        }
    }
    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateUser (@PathVariable("id") Integer id, @RequestBody User user){
        try {
            Optional<User> foundUserOptional = repository.findById(id);

            if (foundUserOptional.isPresent()) {
                User foundUser = foundUserOptional.get();

                foundUser.setName(user.getName());
                foundUser.setEmail(user.getEmail());
                foundUser.setPassword(user.getPassword());

                User updatedUser = repository.save(foundUser);

                return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (BusinessExceptions businessExceptions) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessExceptions.getMessage());
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserByUsername (@PathVariable("id")Integer id) {
        try {
            Optional<User> userById =  repository.findById(id);
        return ResponseEntity.status(200).body(userById);
        } catch (BusinessExceptions businessExceptions) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessExceptions.getMessage());
        }
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable("id") Integer id) {
        try {
            Optional<User> foundUserOptional = repository.findById(id);

            if (foundUserOptional.isPresent()) {
                repository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (BusinessExceptions businessExceptions) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessExceptions.getMessage());
        }
    }
}
