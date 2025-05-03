package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.repos.UserRepository;
import ZCWDelta.ZipTube.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    // This class will handle user-related requests
    // For example, user registration, login, profile management, etc.
    // It will interact with the UserService to perform these operations

    // Example endpoint for user registration
    // @PostMapping("/register")
    // public ResponseEntity<?> registerUser(@RequestBody User user) {
    //     return userService.registerUser(user);
    // }

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
