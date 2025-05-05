package ZCWDelta.ZipTube.services;


import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Component
public class CommentService {

    @Autowired
    private CommentRepo repo;

    public CommentService(CommentRepo repo) {
        this.repo = repo;
    }

    public List<Comment> getAllComments() {
        return repo.findAll();
    }

    public Comment show(Integer id) {
        return repo.findById(id).get();
    }

    public List<Comment> findByVideoId(Video videoId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (Objects.equals(comment.getVideoId().getVideoId(), videoId.getVideoId())) {
                comments.add(comment);
            }
        }
        return comments;
    }

    public List<Comment> findByUserId(User userId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (Objects.equals(comment.getUserId().getId(), userId.getId())) {
                comments.add(comment);
            }
        }
        return comments;
    }

    public Comment create(Comment comment) {
        return repo.save(comment);
    }

    public Boolean delete(Integer id) {
        repo.deleteById(id);
        return true;
    }

    public Boolean deleteByUser(User userId) {
        List<Comment> comments = findByUserId(userId);
        repo.deleteAll(comments);
        return true;
    }

    public Boolean deleteByVideo(Video videoId) {
        List<Comment> comments = findByVideoId(videoId);
        repo.deleteAll(comments);
        return true;
    }

    public void cleanUp() {
        repo.deleteAll();
    }
}
