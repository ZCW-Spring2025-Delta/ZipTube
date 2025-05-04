package ZCWDelta.ZipTube.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    void testUsername() {
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
    void testFirstName() {
        //Given
        String firstName = "John";

        user.setFirstName(firstName);

        String expected = firstName;

        String actual = user.getFirstName();

        assertEquals(expected, actual);
    }

    @Test
    void testLastName() {
        String lastName = "Doe";

        user.setLastName(lastName);

        String actual = user.getLastName();

        assertEquals(lastName, actual);
    }

    @Test
    void testEmail() {
        String testEmail = "codeNinja67@gmail.com";

        user.setEmail(testEmail);

        String expected = testEmail;

        String actual = user.getEmail();

        assertEquals(testEmail, actual);
    }

    @Test
    void testPassword() {
        String password = "W9r#zL!8qTm@2Xe";

        user.setPassword(password);

        String expected = password;

        String actual = user.getPassword();

        assertEquals(expected, actual);
    }

//    @Test
//    void testFavorites() { //May not need
//        String favorite1 = "Prometheus";
//        String favorite2 = "Half Baked";
//        String favorite3 = "Iron Mike";
//        ArrayList<String> favoritesList = new ArrayList<>();
//
//        user.setFavorites(favorite1);
//        user.setFavorites(favorite2);
//        user.setFavorites(favorite3);
//
//        favoritesList.add(favorite1);
//        favoritesList.add(favorite2);
//        favoritesList.add(favorite3);
//
//        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Prometheus", "Half Baked" , "Iron Mike"));
//        ArrayList<String> actual = user.getFavorites();
//        assertEquals(expected, user);
//    }

    @Test
    void testUpload() {//May not need
    }

    @Test
    void testCommentId() {
        Integer commentID = 1043827;

        user.setCommentId(commentID);

        Integer expected = commentID;

        Integer actual = user.getCommentId();

        assertEquals(expected, actual);
    }
}
