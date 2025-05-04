package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = service.getAllComments();
        if (comments == null) {
            return new ResponseEntity<Iterable<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Comment>>(comments, HttpStatus.OK);
    }

    @GetMapping("/video/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Comment>> getByVideo(@PathVariable("videoId") Integer videoId) {
        Iterable<Comment> comments = service.findByVideoId(videoId);
        if (comments == null) {
            return new ResponseEntity<Iterable<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Comment>>(comments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment> getComment(@PathVariable("id") Integer id) {
        Comment comment = service.show(id);
        if (comment == null) {
            return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Comment>(service.show(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Comment>> getByUser(@PathVariable("userId") Integer userId) {
        Iterable<Comment> byUsers = service.findByUserId(userId);
        if (byUsers == null) {
            return new ResponseEntity<Iterable<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Comment>>(byUsers, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comment> writeComment(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(service.create(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteComment(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @DeleteMapping("/video/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteByVideo(@PathVariable("videoId") Integer videoId) {
        return new ResponseEntity<>(service.deleteByVideo(videoId), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteByUser(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(service.deleteByUser(userId), HttpStatus.OK);
    }

}
