package ZCWDelta.ZipTube.repos;

import ZCWDelta.ZipTube.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepo extends JpaRepository<Video, Integer> {
    List<Video> findByUploaderUsername(String username);
    List<Video> findByUploaderId(Integer userId);

    List<Video> findByUploaderIdAndFavoriteTrue(Integer userId);
}
