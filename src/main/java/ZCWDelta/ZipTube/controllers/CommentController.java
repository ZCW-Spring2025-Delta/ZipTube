package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/video/{videoId}")
    public Iterable<Comment> getByVideo(Integer videoId) {
        return service.findByVideoId(videoId);
    }

    @GetMapping("/{id}")
    public Comment getComment(Integer id) {
        return service.show(id);
    }

    @GetMapping("/{userId}")
    public Iterable<Comment> getByUser(Integer userId) {
        return null;
    }

}
