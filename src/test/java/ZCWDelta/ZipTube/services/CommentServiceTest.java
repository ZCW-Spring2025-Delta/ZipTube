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
        Assertions.assertFalse(comments.isEmpty());
    }

    @Test
    public void testShowById() {
        Comment comment = new Comment("String", null, null);
        service.create(comment);

        Assertions.assertNotNull(service.show(comment.getId()));
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        service.create(new Comment("String", user, null));
        List<Comment> comments = service.findByUserId(user);

        Assertions.assertNotNull(comments);
        Assertions.assertFalse(comments.isEmpty());
    }

    @Test
    public void testFindByVideo() {
        Video video = new Video();
        service.create(new Comment("String", null, video));
        List<Comment> comments = service.findByVideoId(video);

        Assertions.assertNotNull(comments);
        Assertions.assertFalse(comments.isEmpty());
    }

    @Test
    public void testDeleteById() {
        Comment comment = new Comment("String", null, null);
        service.create(comment);
        Assertions.assertFalse(service.getAllComments().isEmpty());

        service.delete(comment.getId());
        Assertions.assertTrue(service.getAllComments().isEmpty());
    }

    @Test
    public void testDeleteByUser() {
        User user1 = new User();
        User user2 = new User();
        service.create(new Comment("String", user1, null));
        service.create(new Comment("String", user2, null));
        Assertions.assertEquals(2, service.getAllComments().size());
        service.deleteByUser(user1);
        Assertions.assertEquals(1, service.getAllComments().size());
    }

    @Test
    public void testDeleteByVideo() {
        Video video1 = new Video();
        Video video2 = new Video();
        service.create(new Comment("String", null, video1));
        service.create(new Comment("String", null, video2));
        Assertions.assertEquals(2, service.getAllComments().size());
        service.deleteByVideo(video1);
        Assertions.assertEquals(1, service.getAllComments().size());
    }

}
