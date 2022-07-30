package UnitTestingMockito.UnitTestingMockito.controllers;

import UnitTestingMockito.UnitTestingMockito.models.User;
import UnitTestingMockito.UnitTestingMockito.services.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserInterface userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @GetMapping("/getUsers")
    public List<User> findAllUsers() {
        return userService.findAll();
    }
    public User deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return user;
    }


}
