package ZCWDelta.ZipTube.repos;

import ZCWDelta.ZipTube.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
