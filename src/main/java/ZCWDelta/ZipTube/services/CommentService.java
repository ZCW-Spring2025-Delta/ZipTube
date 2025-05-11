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

    public Comment[] getAllComments() {
        return repo.findAll().toArray(new Comment[0]);
    }

    public Comment show(Integer id) {
        return repo.findById(id).get();
    }

    public Comment[] findByVideoId(Video videoId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (Objects.equals(comment.getVideoId().getVideoId(), videoId.getVideoId())) {
                comments.add(comment);
            }
        }
        return comments.toArray(new Comment[0]);
    }

    public Comment[] findByUserId(User userId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (Objects.equals(comment.getUserId().getId(), userId.getId())) {
                comments.add(comment);
            }
        }
        return comments.toArray(new Comment[0]);
    }

    public Comment[] findByUsername(String username) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (Objects.equals(comment.getUsername(), username)) {
                comments.add(comment);
            }
        }
        return comments.toArray(new Comment[0]);
    }

    public Comment create(Comment comment) {
        return repo.save(comment);
    }

    public Boolean delete(Integer id) {
        repo.deleteById(id);
        return true;
    }

    public Boolean deleteByUser(User userId) {
        Comment[] comments = findByUserId(userId);
        repo.deleteAll(List.of(comments));
        return true;
    }

    public Boolean deleteByVideo(Video videoId) {
        Comment[] comments = findByVideoId(videoId);
        repo.deleteAll(List.of(comments));
        return true;
    }

    public void cleanUp() {
        repo.deleteAll();
    }
}
