package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.ZipTubeApplication;
import ZCWDelta.ZipTube.controllers.CommentController;
import ZCWDelta.ZipTube.repos.CommentRepo;
import ZCWDelta.ZipTube.models.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService service;


    @Test
    public void testCreateComment() {
        Comment comment = new Comment("String", null, null);
        Comment actual = service.create(comment);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals("String", actual.getText());
    }

    @Test
    public void testShowAll() {
        Comment comment = new Comment("String", null, null);
        service.create(comment);
        List<Comment> comments = service.getAllComments();

        Assertions.assertNotNull(comments);
        Assertions.assertTrue(comments.size() > 0);
    }

    @Test
    public void testShowById() {
        Comment comment = new Comment("String", null, null);
        service.create(comment);

        Assertions.assertNotNull(service.show(comment.getId()));
    }

    //write tests for:
    //find by video
    //find by user
    //delete by id
    //delete by user
    //delete by video

}
