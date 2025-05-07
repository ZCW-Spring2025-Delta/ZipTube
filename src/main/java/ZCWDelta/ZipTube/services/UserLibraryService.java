//package ZCWDelta.ZipTube.services;
//
//import ZCWDelta.ZipTube.models.User;
//import ZCWDelta.ZipTube.models.UserLibrary;
//import ZCWDelta.ZipTube.models.Video;
//import ZCWDelta.ZipTube.repos.UserLibraryRepo;
//import ZCWDelta.ZipTube.repos.VideoRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Component
//public class UserLibraryService {
//
//    @Autowired
//    UserLibraryRepo userLibraryRepo;
//    @Autowired
//    VideoRepo videoRepo;
//
//    public List<UserLibrary> showAll() {
//        return userLibraryRepo.findAll();
//    }
//    public Optional<UserLibrary> getVideosByUserId(Integer userId) {
////        userLibraryRepo.findById()
//        return userLibraryRepo.findById(userId);
//    }
//
//    public UserLibrary showById(Integer id) {
//        return userLibraryRepo.findById(id).get();
//    }
////get all favorite videos
//    public List<Video> showAllFavorites(Integer userLibraryId) {
//        List<Video> favorites = new ArrayList<>();
//        UserLibrary library = userLibraryRepo.getReferenceById(userLibraryId);
//        Integer videoId = library.getVideoId();
//        Video video = videoRepo.getReferenceById(videoId);
//        if (video.getFavorite()){
//            favorites.add(video);
//        }
//        return favorites;
//    }
//
//    //get all uploads videos
//    public List<Video> showAllUploads(Integer userLibraryId) {
//        UserLibrary library = userLibraryRepo.getReferenceById(userLibraryId);
//        List<Video> uploads = library.getUploads();
//        return uploads;
//    }
//
//    public UserLibrary create(UserLibrary userLibrary) {
//        return userLibraryRepo.save(userLibrary);
//    }
//// how we get add to the list of favorites
//    public Boolean addToFavorites(Video video, Integer userLibraryId) {
//        UserLibrary library = userLibraryRepo.getReferenceById(userLibraryId);
//        Integer videoId = library.getVideoId();
//        video.setFavorite(true);
//        return video.getFavorite();
//    }
//
//    // how we get add to the list of uploads
//    public List<Video> addToUploads(Video video, User user) {
//        UserLibrary library = user.getUserLibraryId();
//        List<Video> uploads = library.getUploads();
//
//        if (!uploads.contains(video)) {
//            uploads.add(video);
//            userLibraryRepo.save(library);
//        }
//
//        return uploads;
//    }
//
//    // delete uploaded video
//    public Boolean delete(UserLibrary userLibrary, Integer videoId) {
//        Optional<UserLibrary> itemOptional = userLibraryRepo.findById(userLibrary.getVideoId());
//
//        if (itemOptional.isPresent()) {
//            userLibraryRepo.deleteById(userLibrary.getVideoId());
//            return true; // successfully deleted
//        } else {
//            return false; // no item found to delete
//        }
//    }
//}
