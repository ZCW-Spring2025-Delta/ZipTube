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

    @Test //postmapping
    public void testCreateComment() throws Exception {
        Comment comment = new Comment(null, "String", null, null);
        ResponseEntity<Comment> response = testTemplate.postForEntity("/comments", comment, Comment.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("String", response.getBody().getText());
    }

    @Test //getmapping all
    public void testShowAllComments() {
        ResponseEntity<Comment[]> comments = testTemplate.getForEntity("/comments/all", Comment[].class);

        Assertions.assertEquals(HttpStatus.OK, comments.getStatusCode());
        Assertions.assertNotNull(comments.getBody());
        Assertions.assertTrue(comments.getBody().length >= 0);
    }

    @Test //getmapping by comment id
    public void testShowById() {
        Comment actual = new Comment("String", null, null);
        Comment posted = testTemplate.postForObject("/comments", actual, Comment.class);
        ResponseEntity<Comment> response = testTemplate.getForEntity("/comments/"
                + posted.getId(), Comment.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("String", response.getBody().getText());
    }

    @Test //get mapping by user id
    public void testShowByUser() {
        User user = new User();
        Comment actual = new Comment("String", user, null);
        Comment posted = testTemplate.postForObject("/comments", actual, Comment.class);
        ResponseEntity<Comment[]> response = testTemplate.getForEntity("/comments/user/"
                + posted.getUserId().getId(), Comment[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test //getmapping by video id
    public void testShowByVideo() {
        Video video = new Video();
        Comment actual = new Comment("string", null, video);
        Comment posted = testTemplate.postForObject("/comments", actual, Comment.class);
        ResponseEntity<Comment[]> response = testTemplate.getForEntity("/comments/video/"
                + posted.getVideoId().getVideoId(), Comment[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test //deletemapping by id
    public void testDeleteById() {
        Comment comment = new Comment("String", null, null);
        testTemplate.postForObject("/comments", comment, Comment.class);
        testTemplate.delete("/comments/" + comment.getId());

        ResponseEntity<Void> response = testTemplate.getForEntity("/comments/"
                + comment.getId() + "/", Void.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test //deletemapping by user id
    public void testDeleteByUserId() {
        User user = new User();
        Comment comment = new Comment("", user, null);
        testTemplate.postForObject("/comments", comment, Comment.class);
        testTemplate.delete("/comments/user/" + comment.getUserId().getId());

        ResponseEntity<Void> response = testTemplate.getForEntity("/comments/user/"
                + comment.getUserId().getId() + "/", Void.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test //deletemapping by video id
    public void testDeleteByVideoId() {
        Video video = new Video();
        Comment comment = new Comment("String", null, video);
        testTemplate.postForObject("/comments", comment, Comment.class);
        testTemplate.delete("comments/video/" + comment.getVideoId().getVideoId());

        ResponseEntity<Void> response = testTemplate.getForEntity("/comments/video/"
                + comment.getVideoId().getVideoId() + "/", Void.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
