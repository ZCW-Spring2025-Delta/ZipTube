package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateUser() {
        User user = new User(null, "LilRed543", "Alice", "Smith", "alice@example.com", "pass123!", 101);
        ResponseEntity<User> response = restTemplate.postForEntity("/user", user, User.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("LilRed543", response.getBody().getUsername());
    }

    @Test
    void testGetAllUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("/user", User[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 0); // Should be empty or filled
    }

    @Test
    void testGetUserById() {
        // First, create a user
        User user = new User(null, "SideShowCoder12", "Bob", "Jones", "bob@example.com", "secretPass!", 202);
        User created = restTemplate.postForObject("/user", user, User.class);

        // Now fetch it by ID
        ResponseEntity<User> response = restTemplate.getForEntity("/user/" + created.getId(), User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("SideShowCoder12", response.getBody().getUsername());
    }

    @Test
    void testUpdateUser() {
        // Create a user
        User user = new User(null, "OldUsername", "Jane", "Doe", "jane@example.com", "oldpass!", 303);
        User created = restTemplate.postForObject("/user", user, User.class);

        // Update the username and email
        created.setUsername("MyCodeisCoolerThnYurz65");
        created.setEmail("updated@example.com");

        HttpEntity<User> requestEntity = new HttpEntity<>(created);
        ResponseEntity<User> response = restTemplate.exchange("/user/" + created.getId(), HttpMethod.PUT, requestEntity, User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("MyCodeisCoolerthnYurz65", response.getBody().getUsername());
    }

    @Test
    void testDeleteUser() {
        // Create a user
        User user = new User(null, "DeleteMe", "Sam", "Delete", "delete@example.com", "tobedeleted!", 404);
        User created = restTemplate.postForObject("/user", user, User.class);

        // Delete the user
        restTemplate.delete("/user/" + created.getId());

        // Try to fetch (should return 404)
        ResponseEntity<String> response = restTemplate.getForEntity("/user/" + created.getId(), String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
