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
        User user = new User();
        user.setUsername("CodeNinja67");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("codeninja67@gmail.com");
        user.setPassword("J7v@92Lm#tQx");
        user.setCommentId(123);
        User savedUser = userService.createUser(user);

        assertNotNull(savedUser.getId());
        assertEquals("CodeNinja67", savedUser.getUsername());
    }

    @Test
    void testGetAllUsers() {
        User user = new User();

        user.setId(23);
        user.setUsername("CodeNinja67");
        user.setFirstName("Gabriel");
        user.setLastName("Cruz");
        user.setEmail("example@gmail.com");
        user.setPassword("h5u4ji3l2h5");
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 0); // Should return list even if empty
    }

    @Test
    void testFindById() {
        Optional<User> found = userService.findById(52);
        assertTrue(found.isPresent());
    }

    @Test
    void testUpdateUser() throws UserNotFoundException {
        User user = new User();
        user.setUsername("CodeNinja67");
        user.setFirstName("Gabriel");
        user.setLastName("Cruz");
        user.setEmail("example@gmail.com");
        user.setPassword("h5u4ji3l2h5");
        User saved = userService.createUser(user);

        saved.setUsername("CodeHashr");
        saved.setEmail("Checkr@protonmail.com");

        User updated = userService.updateUser(saved.getId(), saved);

        assertEquals("CodeHashr", updated.getUsername());
        assertEquals("Checkr@protonmail.com", updated.getEmail());
    }

    @Test
    void testDeleteUser() throws UserNotFoundException {
        User user = new User();
        user.setUsername("CodeNinja67");
        user.setFirstName("Gabriel");
        user.setLastName("Cruz");
        user.setEmail("example@gmail.com");
        user.setPassword("h5u4ji3l2h5");
        User saved = userService.createUser(user);

        userService.deleteUser(saved.getId());

        Optional<User> found = userService.findById(saved.getId());
        assertFalse(found.isPresent());

    }
}
