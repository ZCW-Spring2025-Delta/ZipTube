package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.VideoDTO;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    // Simulating authentication
    private String getCurrentUsername() {
        // Replace this with actual logic from Spring Security
        return "testUser"; // Example: SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos(){
        return new ResponseEntity<>(videoService.showAll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Video>> getMyVideos(){
        return new ResponseEntity<>(videoService.getVideosByUser(getCurrentUsername()), HttpStatus.OK);
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<Video> getVideosById(@PathVariable Integer videoId) {
        return videoService.getVideoById(videoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/favorites/{userId}")
    public ResponseEntity<List<Video>> getUserFavorites(@PathVariable Integer userId) {
        return ResponseEntity.ok(videoService.getFavoritesByUser(userId));
    }

    @PostMapping("/{videoId}/toggle-favorite")
    public ResponseEntity<Video> toggleFavorite(@PathVariable Integer videoId) {
        return ResponseEntity.ok(videoService.toggleFavorite(videoId));
    }

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody VideoDTO videoDTO){
        Video video = videoService.createVideo(videoDTO, getCurrentUsername());
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

    @PutMapping("/{videoId}")
    public ResponseEntity<Video> update(@PathVariable Integer videoId, @RequestBody VideoDTO videoDTO){
        String username = getCurrentUsername();
        Optional<Video> optionalVideo = videoService.getVideoById(videoId);
        if (optionalVideo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Video video = optionalVideo.get();
        if (!video.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        video.setVideoName(videoDTO.getVideoName());
        video.setQuery(videoDTO.getQuery());
        video.setURL(videoDTO.getURL());
        video.setYear(videoDTO.getYear());
        video.setFavorite(videoDTO.getFavorite());
        video.setUploaded(videoDTO.getUploaded());

        return  new ResponseEntity<>(videoService.update(videoId, video), HttpStatus.OK);

    }

    @DeleteMapping("/{videoId}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Integer videoId) {
        String username = getCurrentUsername();
        Optional<Video> optionalVideo = videoService.getVideoById(videoId);

        if (optionalVideo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Video video = optionalVideo.get();
        if (!video.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        videoService.delete(video);
        return ResponseEntity.noContent().build();
    }


}
