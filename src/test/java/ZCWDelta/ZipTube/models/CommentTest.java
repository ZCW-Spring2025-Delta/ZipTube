package ZCWDelta.ZipTube.models;

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
        Comment comment2 = new Comment(2, "String text", 4, 2);
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
        comment.setUserId(3);
        Assertions.assertEquals(3, comment.getUserId());
    }

    @Test
    public void testGetSetVideoId() {
        Assertions.assertNull(comment.getVideoId());
        comment.setVideoId(4);
        Assertions.assertEquals(4, comment.getVideoId());
    }

    //add a createJSON test?
}
