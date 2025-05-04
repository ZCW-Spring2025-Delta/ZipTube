package ZCWDelta.ZipTube.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CommentTest {
    Comment comment = new Comment();

    @Test
    public void testEntityAnnotation() {
        Assertions.assertTrue(Comment.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testNullConstructor() {
        Comment comment2 = new Comment();
        Assertions.assertNotNull(comment2);
    }

    @Test
    public void testArgConstructor() {
        Comment comment2 = new Comment(2, "String text", null, null);
        Assertions.assertNotNull(comment2);
    }

    @Test
    public void testGetSetId() {
        Assertions.assertNull(comment.getId());
        comment.setId(1);
        Assertions.assertEquals(1, comment.getId());
    }

    @Test
    public void testGetSetText() {
        Assertions.assertNull(comment.getText());
        String commentText = "Here's a string of words for a comment";
        comment.setText(commentText);
        Assertions.assertEquals(commentText, comment.getText());
    }

    @Test
    public void testGetSetUserId() {
        Assertions.assertNull(comment.getUserId());
        User newUser = new User();
        comment.setUserId(newUser);
        Assertions.assertEquals(newUser, comment.getUserId());
    }

    @Test
    public void testGetSetVideoId() {
        Assertions.assertNull(comment.getVideoId());
        Video newVideo = new Video();
        comment.setVideoId(newVideo);
        Assertions.assertEquals(newVideo, comment.getVideoId());
    }

    @Test
    public void testCreateJSON() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Comment comment = new Comment();
        String json = jsonWriter.writeValueAsString(comment);
    }
}
