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
//    User user = new User;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateUser() {
        UserControllerTest testUser = new UserControllerTest();
        User user;

        user = testUser.createTestUser();


        ResponseEntity<User> response = restTemplate.postForEntity("/user", user, User.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
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
        UserControllerTest testUser = new UserControllerTest();
        User user;

        user = testUser.createTestUser();
        user.setId(4);
        User created = restTemplate.postForObject("/user", user, User.class);

        // Now fetch it by ID
        ResponseEntity<User> response = restTemplate.getForEntity("/user/" + created.getId(), User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testUpdateUser() {
        // Create a user
        UserControllerTest testUser = new UserControllerTest();
        User user;

        user = testUser.createTestUser();
        user.setId(3);
        User created = restTemplate.postForObject("/user/", user, User.class);

        // Update the username and email
        user.setUsername("MyCodeisCoolerThnYurz65");
        user.setEmail("updated@example.com");
        user.setPassword("newpasswrd574893");

        User expected = new User(3, "MyCodeisCoolerthnYurz65", "John", "Stockton", "updated@example.com", "newpasswrd574893", 409);

        HttpEntity<User> requestEntity = new HttpEntity<>(created);
        ResponseEntity<User> response = restTemplate.exchange("/user/" + user.getId(), HttpMethod.PUT, requestEntity, User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, user);
    }

    @Test
    void testDeleteUser() {
        // Create a user
        UserControllerTest testUser = new UserControllerTest();
        User user;

        user = testUser.createTestUser();
        user.setId(2);
        // Delete the user
        restTemplate.delete("/user/" + user.getId());

        // Try to fetch (should return 404)
        ResponseEntity<String> response = restTemplate.getForEntity("/user/" + user.getId(), String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    public User createTestUser(){
        User user = new User();
        user.setEmail("example@gmail.com");
        user.setUsername("codeMonger89");
        user.setFirstName("John");
        user.setLastName("Stockton");
        user.setPassword("5j43k2;");
        user.setCommentId(409);

        return user;
    }

//    public boolean equals(Object obj){
//        if(obj == this){
//            return true;
//        }
//        if (!(obj instanceof User)){
//            return false;
//        }
//
//        User other = (User) obj;
//        return other.getUsername().equals(this.username) && other.firstName.equals(this.firstName) && other.lastName.equals(this.lastName) &&
//                other.email.equals(this.email) && other.password.equals(this.password) && other.commentId.equals(this.commentId);
//    }
}
