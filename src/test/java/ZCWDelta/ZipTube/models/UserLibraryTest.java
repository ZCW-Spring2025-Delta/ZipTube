//package ZCWDelta.ZipTube.models;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.persistence.Entity;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class UserLibraryTest {
//    private UserLibrary userLibrary;
//    private Video video;
//
//    @BeforeEach
//    public void setUp(){
//        Video video = new Video();
//        Video video2 = new Video();
//        Video video3 = new Video();
//        List<Video> favorites = Arrays.asList(video);
//        List<Video> uploads = Arrays.asList(video2, video3);
//        userLibrary = new UserLibrary(1, favorites, uploads, 11, 12);
//    }
//    @Test
//    public void testGettersAndSettersId(){
//        //given
//
//        //when
//        Integer actualId = userLibrary.getId();
//        Integer expectedId = 1;
//
//        //Then
//        Assert.assertEquals(expectedId, actualId);
//    }
//
//    @Test
//    public void testGettersAndSettersSize(){
//
//
//        //given
//        userLibrary.getFavorites();
//        //when
//        Integer actualInteger = userLibrary.getFavorites().size();
//        Integer expectedInteger = 1;
//        Integer actualUploadsInteger = userLibrary.getUploads().size();
//        Integer expectedUploadsInteger = 2;
//        //when;
//
//        //Then
//        Assert.assertEquals(expectedInteger, actualInteger);
//        Assert.assertEquals(expectedUploadsInteger, actualUploadsInteger);
//    }
//
//    @Test
//    public void testGettersAndSettersUserId(){
//        //given
//
//        //when
//        Integer actualUserId = userLibrary.getUserId();
//        Integer expectedUserId = 11;
//        Integer actualVideoId = userLibrary.getVideoId();
//        Integer expectedVideoId = 12;
//        //when;
//
//        //Then
//        Assert.assertEquals(expectedUserId, actualUserId);
//        Assert.assertEquals(expectedVideoId, actualVideoId);
//    }
//
//
//
//    @Test
//    public void testCreateJson() throws JsonProcessingException {
//        ObjectMapper jsonWriter = new ObjectMapper();
//        UserLibrary library = new UserLibrary();
//        String json = jsonWriter.writeValueAsString(library);
//
//        Assert.assertTrue(json.contains("id"));
//        Assert.assertTrue(json.contains("favorites"));
//        Assert.assertTrue(json.contains("uploads"));
//    }
//
//    @Test
//    public void testClassSignatureAnnotations() {
//        Assert.assertTrue(UserLibrary.class.isAnnotationPresent(Entity.class));
//    }
//}
