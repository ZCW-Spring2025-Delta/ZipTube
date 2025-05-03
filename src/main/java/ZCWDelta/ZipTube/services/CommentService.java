package ZCWDelta.ZipTube.services;


import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Component
public class CommentService {

    @Autowired
    private CommentRepo repo;

    public CommentService(CommentRepo repo) {
        this.repo = repo;
    }

    public Iterable<Comment> getAllComments() {
        return repo.findAll();
    }

    public Comment show(Integer id) {
        return repo.findById(id).get();
    }

    public Iterable<Comment> findByVideoId(Integer videoId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (comment.getVideoId() == videoId) {
                comments.add(comment);
            }
        }
        return comments;
    }

    public Iterable<Comment> findByUserId(Integer userId) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (Comment comment : repo.findAll()) {
            if (comment.getVideoId() == userId) {
                comments.add(comment);
            }
        }
        return comments;
    }
}
