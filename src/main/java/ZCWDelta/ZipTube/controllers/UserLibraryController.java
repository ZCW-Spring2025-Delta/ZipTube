package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.services.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class UserLibraryController {

    @Autowired
    UserLibraryService userLibraryService;

    public UserLibraryController(UserLibraryService userLibraryService){
        this.userLibraryService = userLibraryService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<Iterable<Video>> getAllFavorites(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>(userLibraryService.showAllFavorites(id, user), HttpStatus.OK);
    }

    @GetMapping("/uploads")
    public ResponseEntity<Iterable<Video>> getAllUploads(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>(userLibraryService.showAllUploads(id, user), HttpStatus.OK);
    }

}
