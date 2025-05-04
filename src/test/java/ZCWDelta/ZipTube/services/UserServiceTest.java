package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        User user = new User(null, "CodeNinja67", "John", "Doe", "codeninja67@gmail.com", "J7v@92Lm#tQx", 123);
        User savedUser = userService.createUser(user);

        assertNotNull(savedUser.getId());
        assertEquals("CodeNinja67", savedUser.getUsername());
    }

    @Test
    void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 0); // Should return list even if empty
    }

    @Test
    void testFindById() {
        User user = new User(null, "codeMatador0990", "Alex", "Smith", "alex@testmail.com", "f78dsa90", 456);
        User saved = userService.createUser(user);

        Optional<User> found = userService.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("TestFind", found.get().getUsername());
    }

    @Test
    void testUpdateUser() throws UserNotFoundException {
        User user = new User(null, "Dc0dr", "Tom", "Hanks", "tom@gmail.com", "f7ds8a9z", 789);
        User saved = userService.createUser(user);

        User updates = new User();
        updates.setUsername("CodeHashr");
        updates.setEmail("Checkr@protonmail.com");

        User updated = userService.updateUser(saved.getId(), updates);

        assertEquals("CodeHashr", updated.getUsername());
        assertEquals("Checkr@protonmail.com", updated.getEmail());
    }

    @Test
    void testDeleteUser() throws UserNotFoundException {
        User user = new User(null, "DeleteMe", "Jane", "Doe", "jane@example.com", "delete123", 999);
        User saved = userService.createUser(user);

        userService.deleteUser(saved.getId());

        Optional<User> found = userService.findById(saved.getId());
        assertFalse(found.isPresent());

    }
}
