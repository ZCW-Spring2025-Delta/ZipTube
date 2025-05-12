package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.models.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService service;

    @BeforeEach
    public void setUp() {
        service.cleanUp();
    }

    @Test
    public void testCreateComment() {
        Comment comment = new Comment("String", 2, 3);
        Comment actual = service.create(comment);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals("String", actual.getText());
    }

    @Test
    public void testShowAll() {
        Comment comment = new Comment("String", 2, 3);
        Comment comment2 = new Comment("String", 2, 3);
        service.create(comment);
        service.create(comment2);
        Comment[] comments = service.getAllComments();

        Assertions.assertNotNull(comments);
        Assertions.assertFalse(comments.length == 0);
    }

    @Test
    public void testShowById() {
        Comment comment = new Comment("String", 2, 3);
        service.create(comment);

        Assertions.assertNotNull(service.show(comment.getId()));
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        service.create(new Comment("String", user, null));
        Comment[] comments = service.findByUserId(user);

        Assertions.assertNotNull(comments);
        Assertions.assertFalse(comments.length == 0);
    }

    @Test
    public void testFindByVideo() {
        Video video = new Video();
        service.create(new Comment("String", 2, video.getVideoId()));
        Comment[] comments = service.findByVideoId(video);

        Assertions.assertNotNull(comments);
        Assertions.assertFalse(comments.length == 0);
    }

    @Test
    public void testDeleteById() {
        Comment comment = new Comment("String", 2, 3);
        service.create(comment);
        Assertions.assertFalse(service.getAllComments().length == 0);

        service.delete(comment.getId());
        Assertions.assertTrue(service.getAllComments().length == 0);
    }

    @Test
    public void testDeleteByUser() {
        User user1 = new User();
        User user2 = new User();
        service.create(new Comment("String", user1, 3));
        service.create(new Comment("String", user2, 3));
        Assertions.assertEquals(2, service.getAllComments().length);
        service.deleteByUser(user1);
        Assertions.assertEquals(1, service.getAllComments().length);
    }

    @Test
    public void testDeleteByVideo() {
        Video video1 = new Video();
        Video video2 = new Video();
        service.create(new Comment("String", 2, video1.getVideoId()));
        service.create(new Comment("String", 2, video2.getVideoId()));
        Assertions.assertEquals(2, service.getAllComments().length);
        service.deleteByVideo(video1);
        Assertions.assertEquals(1, service.getAllComments().length);
    }

}
