package ZCWDelta.ZipTube.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    User user = new User();


    @Test
    void defaultConstructorTest(){
    }

    @Test
    void constructorTest(){

    }

    @Test
    void getUsername() {
        //Given
        String username = "CodeNinja67";

        //When
        user.setUsername(username);

        String expected = username;

        String actual = user.getUsername();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void getFirstName() {
        //Given
        String firstName = "John";

        user.setFirstName(firstName);

        String expected = firstName;

        String actual = user.getFirstName();

        assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String lastName = "Doe";

        user.setLastName(lastName);

        String actual = user.getLastName();

        assertEquals(lastName, actual);

    }

    @Test
    void getEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getFavorites() {
    }

    @Test
    void getUpload() {
    }

    @Test
    void getCommentId() {
    }

    @Test
    void getUserLibraryId() {
    }
}
