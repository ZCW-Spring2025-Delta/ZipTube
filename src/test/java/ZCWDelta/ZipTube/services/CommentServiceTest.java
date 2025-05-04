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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ZipTubeApplication.class)
public class CommentServiceTest {

    private CommentService service;

    private CommentController controller;

    private CommentRepo repo;

    @Before
    public void setUp() {
        this.controller = new CommentController(service);
        this.service = new CommentService(repo);
    }

    @Test
    public void testCreateComment() {
        HttpStatus expected = HttpStatus.CREATED;
        Comment expectedComment = new Comment("string", null, null);
        BDDMockito.given(service.create(expectedComment)).willReturn(expectedComment);

        ResponseEntity<Comment> response = controller.writeComment(expectedComment);
        HttpStatusCode actual = response.getStatusCode();
        Comment actualComment = response.getBody();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedComment, actualComment);
    }

    @Test
    public void testShowComment() {
        Integer givenId = 1;
        HttpStatus expected = HttpStatus.OK;
        Comment expectedComment = new Comment(givenId, "String", null, null);
        BDDMockito.given(service.show(1)).willReturn(expectedComment);

        ResponseEntity<Comment> response = controller.getComment(givenId);
        HttpStatusCode actual = response.getStatusCode();
        Comment actualComment = response.getBody();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedComment, actualComment);
    }

}
