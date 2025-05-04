package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
// This is to test the Service class methods

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        User user = new User(1, "CodeNinja67", "John", "Doe", "codeninja67@gmail.com", "J7v@92Lm#tQx", 123);
    }

    @Test
    void testGetAllUsers() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testUpdateUser() {
    }

    @Test
    void testDeleteUser() {
    }


}
