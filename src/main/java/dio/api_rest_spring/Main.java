package dio.api_rest_spring;

import dio.api_rest_spring.models.User;
import dio.api_rest_spring.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();

        user.setName("bruna2");
        user.setEmail("bruna@bruna.com");
        user.setPassword("bruna123");

        for (User u: repository.findAll()) {
            System.out.println(u);
        }
    }
}
