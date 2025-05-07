package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.repos.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class VideoService {

    @Autowired
    VideoRepo videoRepo;

    public Iterable<Video> showAll() {
        return videoRepo.findAll();
    }
    public List<Video> getVideosByUserId(Integer userId) {
       return videoRepo.findAllById(Collections.singleton(userId));

    }

    public Video showById(Integer videoId) {
        return videoRepo.findById(videoId).get();
    }

    public Video create(Video video) {
        return videoRepo.save(video);
    }

    public Video update(Integer videoId, Video video) {
        Video originalVideo = videoRepo.findById(videoId).get();
        originalVideo.setVideoName(video.getVideoName());
        originalVideo.setQuery(video.getQuery());
        originalVideo.setURL(video.getURL());
        originalVideo.setYear(video.getYear());
        originalVideo.setFavorite(video.getFavorite());
        return videoRepo.save(originalVideo);
    }

    public Boolean delete(Integer videoId) {
        Optional<Video> itemOptional = videoRepo.findById(videoId);

        if (itemOptional.isPresent()) {
            videoRepo.deleteById(videoId);
            return true; // successfully deleted
        } else {
            return false; // no item found to delete
        }
    }


}
