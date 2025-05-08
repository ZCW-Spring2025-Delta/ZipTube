package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.VideoDTO;
import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.repos.UserRepo;
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
    private VideoRepo videoRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Video> showAll() {
        return videoRepo.findAll();
    }
    public List<Video> getVideosByUser(String  username) {
       return videoRepo.findByUploaderUsername(username);
    }

    public Optional<Video> getVideoById(Integer videoId) {
        return videoRepo.findById(videoId);
    }

    public List<Video> getFavoritesByUser(Integer userId) {
        return videoRepo.findByUploaderIdAndFavoriteTrue(userId);
    }

    public Video toggleFavorite(Integer videoId) {
        Video video = videoRepo.findById(videoId).orElseThrow();
        video.setFavorite(!video.getFavorite());
        return videoRepo.save(video);
    }
//create new video by user logged in
    public Video createVideo(VideoDTO videoDTO, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not Found"));

        Video video = new Video();
        video.setVideoName(videoDTO.getVideoName());
        video.setQuery(videoDTO.getQuery());
        video.setURL(videoDTO.getURL());
        video.setUploaded(true);
        video.setFavorite(false);
        video.setYear(videoDTO.getYear());
        video.setUser(user);
        video.setCommentId(videoDTO.getCommentId());

        return videoRepo.save(video);
    }

    public Video update(Integer videoId, Video video) {
        Video originalVideo = videoRepo.findById(videoId).get();
        originalVideo.setVideoName(video.getVideoName());
        originalVideo.setQuery(video.getQuery());
        originalVideo.setURL(video.getURL());
        originalVideo.setYear(video.getYear());
        originalVideo.setFavorite(video.getFavorite());
        originalVideo.setUploaded(video.getUploaded());
        return videoRepo.save(originalVideo);
    }

    public Video save(Video video) {
        return videoRepo.save(video);
    }

    public void delete(Video video) {
        videoRepo.delete(video);
    }


}
