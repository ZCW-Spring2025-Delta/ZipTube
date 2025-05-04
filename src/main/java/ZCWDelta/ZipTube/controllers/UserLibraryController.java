package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.services.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class UserLibraryController {

    @Autowired
    UserLibraryService userLibraryService;

    public UserLibraryController(UserLibraryService userLibraryService){
        this.userLibraryService = userLibraryService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<Iterable<Video>> getAllFavorites(){
        return null;
    }

}
