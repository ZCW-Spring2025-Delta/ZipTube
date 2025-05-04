package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.models.UserLibrary;
import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.repos.UserLibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserLibraryService {

    @Autowired
    UserLibraryRepo userLibraryRepo;

    public List<UserLibrary> showAll() {
        return userLibraryRepo.findAll();
    }
    public Optional<UserLibrary> getVideosByUserId(Integer userId) {
        return userLibraryRepo.findById(userId);
    }

    public UserLibrary showById(Integer id) {
        return userLibraryRepo.findById(id).get();
    }

    public UserLibrary create(UserLibrary userLibrary) {
        return userLibraryRepo.save(userLibrary);
    }

    public List<Video> addToFavorites(Video video, User user) {
//List<Video> faves = user.getFavorites();
        return null;
    }

    public Boolean delete(UserLibrary userLibrary) {
        Optional<UserLibrary> itemOptional = userLibraryRepo.findById(userLibrary.getVideoId());

        if (itemOptional.isPresent()) {
            userLibraryRepo.deleteById(userLibrary.getVideoId());
            return true; // successfully deleted
        } else {
            return false; // no item found to delete
        }
    }
}
