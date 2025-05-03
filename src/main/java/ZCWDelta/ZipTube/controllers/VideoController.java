package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }
    @GetMapping
    public ResponseEntity<Iterable<Video>> getVideos(){
        return new ResponseEntity<>(videoService.showAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Integer Id){
        Video video = videoService.showById(Id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video video){
        Video newVideo = videoService.create(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Video> update(@RequestBody Video video){
        Video newVideo = videoService.update(video.getVideoId(), video);
        return new ResponseEntity<>(newVideo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody Video video){
        videoService.delete(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
