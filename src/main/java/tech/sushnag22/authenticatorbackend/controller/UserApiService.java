package tech.sushnag22.authenticatorbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.sushnag22.authenticatorbackend.model.User;
import tech.sushnag22.authenticatorbackend.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserApiService {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/register")
    public String register(@Valid @RequestBody User user) {

        List<User> users = userRepository.findAll();
        System.out.println("New User -> " + user);

        for (User u: users) {
            if (user.equals(u)) {
                System.out.println("User already exists!");
                return "USER_ALREADY_EXISTS";
            }
        }

        userRepository.save(user);
        return "SUCCESS";

    }

    @PostMapping("/api/login")
    public String login(@Valid @RequestBody User user) {

        List<User> users = userRepository.findAll();

        for (User u: users) {
            if (u.equals(user)) {
                return user.getName();
            }
        }

        return "FAILURE";

    }
}
