//package ZCWDelta.ZipTube.controllers;
//
//import ZCWDelta.ZipTube.models.User;
//import ZCWDelta.ZipTube.models.UserLibrary;
//import ZCWDelta.ZipTube.models.Video;
//import ZCWDelta.ZipTube.services.UserLibraryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/user/library")
//public class UserLibraryController {
//
//    @Autowired
//    UserLibraryService userLibraryService;
//
//    public UserLibraryController(UserLibraryService userLibraryService){
//        this.userLibraryService = userLibraryService;
//    }
////    @GetMapping
////    public ResponseEntity<List<UserLibrary>> showAll(){
////        return new ResponseEntity<>(userLibraryService.showAll(), HttpStatus.OK);
////    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<Optional<UserLibrary>> show(Integer userId){
//        return new ResponseEntity<>(userLibraryService.getVideosByUserId(userId), HttpStatus.OK);
//    }
//
////    @GetMapping("/favorites/{userLibraryId}")
////    public ResponseEntity<Iterable<Video>> getAllFavorites(@PathVariable Integer userLibraryId){
////        return new ResponseEntity<>(userLibraryService.showAllFavorites(userLibraryId), HttpStatus.OK);
////    }
//    @GetMapping("/favorites/{userLibraryId}")
//    public ResponseEntity<List<Video>> getFavoriteVideoById(@PathVariable Integer userLibraryId){
//        List<Video> favorites = userLibraryService.showAllFavorites(userLibraryId);
//        return new ResponseEntity<>(favorites, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/uploads/{userLibraryId}")
//    public ResponseEntity<Iterable<Video>> getAllUploads(@PathVariable Integer userLibraryId){
//        return new ResponseEntity<>(userLibraryService.showAllUploads(userLibraryId), HttpStatus.OK);
//    }
//
//    @GetMapping("/uploads/{id}")
//    public ResponseEntity<Video> getUploadVideoById(@PathVariable Integer userId, @PathVariable Integer videoId){
//        List<Video> uploads = userLibraryService.showAllUploads(userId);
//        return new ResponseEntity<>(uploads.get(videoId), HttpStatus.OK);
//    }
//
//    @PostMapping("/uploads")
//    public ResponseEntity<Video> addToUploads(@RequestBody Video video, @RequestBody User user){
//        List<Video> uploads = userLibraryService.showAllUploads(user.getId());
//        uploads.add(video);
//        return new ResponseEntity<>(video, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/favorites")
//    public ResponseEntity<Video> addToFavorites(@PathVariable Integer userLibraryId, @RequestBody Video video){
//        Boolean favorite = userLibraryService.addToFavorites(video, userLibraryId);
//        return new ResponseEntity<>(video, HttpStatus.CREATED);
//    }
//
//}
