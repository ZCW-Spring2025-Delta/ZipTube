package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.repos.CommentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {

    @Autowired
    private TestRestTemplate testTemplate;

    private CommentRepo repo;

    //may need to wait until H2DB gets set up for tests to run
    @Test //getmapping by id
    public void testShowComment() throws Exception {
        Comment comment = new Comment("String", null, null);
        ResponseEntity<Comment> response = testTemplate.postForEntity("/comment", comment, Comment.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //Assertions.assertNotNull();
    }

//    @Test //getmapping all
//    public void testShowAllComments() {
//
//    }

//    @Test //get mapping by user id
//    public void testShowByUser() {
//
//    }

//    @Test //getmapping by video id
//    public void testShowByVideo() {
//
//    }

    @Test //postmapping
    public void testCreateComment() throws Exception {

    }

//    @Test //deletemapping by id
//    public void testDeleteById() {
//
//    }

//    @Test //deletemapping by user id
//    public void testDeleteByUserId() {
//
//    }

//    @Test //deletemapping by video id
//    public void testDeleteByVideoId() {
//
//    }

}
