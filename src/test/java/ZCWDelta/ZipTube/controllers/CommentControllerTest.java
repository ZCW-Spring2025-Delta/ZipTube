package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Video;
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

    @Autowired
    private CommentController controller;

    @Test //postmapping
    public void testCreateComment() throws Exception {
        Comment comment = new Comment(null, "String", null, null);
        ResponseEntity<Comment> response = controller.writeComment(comment);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("String", response.getBody().getText());
    }

    @Test //getmapping all
    public void testShowAllComments() {
        ResponseEntity<Comment[]> comments = controller.getAllComments();

        Assertions.assertEquals(HttpStatus.OK, comments.getStatusCode());
        Assertions.assertNotNull(comments.getBody());
        Assertions.assertTrue(comments.getBody().length >= 0);
    }

    @Test //getmapping by comment id
    public void testShowById() {
        Comment actual = new Comment("String", null, null);
        Comment posted = testTemplate.postForObject("/comments", actual, Comment.class);
        ResponseEntity<Comment> response = controller.getComment(posted.getId());

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("String", response.getBody().getText());
    }

//    @Test //get mapping by user id
//    public void testShowByUser() {
//        User user = new User(1, "", "", "", "", "", null);
//        User postedUser = testTemplate.postForObject("/user", user, User.class);
//        Comment actual = new Comment("String", postedUser, null);
//        ResponseEntity<Comment[]> response = controller.getByUser(user);
//
//        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assertions.assertNotNull(response.getBody());
//    }

    @Test //getmapping by video id
    public void testShowByVideo() {
        Video video = new Video(1, "", "", false, false, "", "", null, 1);
        Video postedVideo = testTemplate.postForObject("/video", video, Video.class);
        Comment actual = new Comment("string", null, postedVideo);
        ResponseEntity<Comment[]> response = controller.getByVideo(video);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test //deletemapping by id
    public void testDeleteById() {
        Comment comment = new Comment("String", null, null);
        Comment posted = testTemplate.postForObject("/comments", comment, Comment.class);

        ResponseEntity<Boolean> response = controller.deleteComment(posted.getId());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

//    @Test //deletemapping by user id
//    public void testDeleteByUserId() {
//        User user = new User(1, "", "", "", "", "", null);
//        User postedUser = testTemplate.postForObject("/user", user, User.class);
//        Comment comment = new Comment("", user, null);
//        Comment posted = testTemplate.postForObject("/comments", comment, Comment.class);
//
//        ResponseEntity<Boolean> response = controller.deleteByUser(user);
//        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//    }

//    @Test //deletemapping by video id
//    public void testDeleteByVideoId() {
//        Video video = new Video(1, "", "", false, false, "", "", null, 1);
//        Video postedVideo = testTemplate.postForObject("/video", video, Video.class);
//        Comment comment = new Comment("String", null, postedVideo);
//        ResponseEntity<Boolean> response = controller.deleteByVideo(video);
//
//        //ResponseEntity<Boolean> response = controller.deleteByVideo(postedVideo);
//        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//    }

}
