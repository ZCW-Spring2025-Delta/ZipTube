package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.UserLibrary;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.services.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class UserLibraryController {

    @Autowired
    UserLibraryService userLibraryService;

    public UserLibraryController(UserLibraryService userLibraryService){
        this.userLibraryService = userLibraryService;
    }
//    @GetMapping
//    public ResponseEntity<List<UserLibrary>> showAll(){
//        return new ResponseEntity<>(userLibraryService.showAll(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<UserLibrary> show(UserLibrary userLibrary){
        return new ResponseEntity<>(userLibraryService.showById(userLibrary.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/favorites")
    public ResponseEntity<Iterable<Video>> getAllFavorites(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>(userLibraryService.showAllFavorites(id, user), HttpStatus.OK);
    }
    @GetMapping("/favorites/{id}")
    public ResponseEntity<Video> getFavoriteVideoById(@PathVariable Integer videoId, @RequestBody User user){
        List<Video> favorites = userLibraryService.showAllFavorites(user.getId(), user);
        return new ResponseEntity<>(favorites.get(videoId), HttpStatus.OK);
    }

    @GetMapping("/uploads")
    public ResponseEntity<Iterable<Video>> getAllUploads(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>(userLibraryService.showAllUploads(id, user), HttpStatus.OK);
    }

    @GetMapping("/uploads/{id}")
    public ResponseEntity<Video> getUploadVideoById(@PathVariable Integer videoId, @RequestBody User user){
        List<Video> uploads = userLibraryService.showAllUploads(user.getId(), user);
        return new ResponseEntity<>(uploads.get(videoId), HttpStatus.OK);
    }

    @PostMapping("/uploads")
    public ResponseEntity<Video> addToUploads(@PathVariable Video video, @RequestBody User user){
        List<Video> uploads = userLibraryService.showAllUploads(user.getId(), user);
        uploads.add(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

    @PostMapping("/favorites")
    public ResponseEntity<Video> addToFavorites(@PathVariable Video video, @RequestBody User user){
        List<Video> favorites = userLibraryService.showAllFavorites(user.getId(), user);
        favorites.add(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

}
