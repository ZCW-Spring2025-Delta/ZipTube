package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Video;
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

    @GetMapping
    @ResponseBody
    public ResponseEntity<Comment[]> getComments() {
        Comment[] comments = service.getAllComments();
        if (comments == null) {
            return new ResponseEntity<Comment[]>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Comment[]>(comments, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment[]> getAllComments() {
        Comment[] comments = service.getAllComments();
        if (comments == null) {
            return new ResponseEntity<Comment[]>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Comment[]>(comments, HttpStatus.OK);
    }

    @GetMapping("/video/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment[]> getByVideo(@PathVariable("videoId") Integer videoId) {
        Comment[] byVideo = service.findByVideoId(videoId);
        if (byVideo == null) {
            return new ResponseEntity<Comment[]>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Comment[]>(byVideo, HttpStatus.OK);
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

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment[]> getCommentByUsername(@PathVariable("username") String username) {
        Comment[] byUsername = service.findByUsername(username);
        if (byUsername == null) {
            return new ResponseEntity<Comment[]>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Comment[]>(byUsername, HttpStatus.OK);
    }

//    @GetMapping("/user/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Comment[]> getByUser(@PathVariable("userId") User userId) {
//        Comment[] byUsers = service.findByUserId(userId);
//        if (byUsers == null) {
//            return new ResponseEntity<Comment[]>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<Comment[]>(byUsers, HttpStatus.OK);
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comment> writeComment(@RequestBody Comment comment) {
        return new ResponseEntity<Comment>(service.create(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteComment(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

//    @DeleteMapping("/video/{videoId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Boolean> deleteByVideo(@PathVariable("videoId") Integer videoId) {
//        return new ResponseEntity<>(service.deleteByVideo(videoId), HttpStatus.OK);
//    }

//    @DeleteMapping("/user/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Boolean> deleteByUser(@PathVariable("userId") User userId) {
//        return new ResponseEntity<>(service.deleteByUser(userId), HttpStatus.OK);
//    }

}
