package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.ZipTubeApplication;
import ZCWDelta.ZipTube.controllers.VideoController;
import ZCWDelta.ZipTube.models.UserLibrary;
import ZCWDelta.ZipTube.models.Video;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ZipTubeApplication.class)
public class VideoServiceTest {

    private Video video;
    @Mock
    private VideoService service;
    @InjectMocks
    public VideoController controller;

    @BeforeEach
    public void setUp(){
        this.controller = new VideoController(service);
        Integer id = 1;
        String videoName = "movie of the year";
        String query = "documentary";
        Boolean favorite = true;
        String year = "12-11-2022";
        String url = "www.hereisthevideo.com";
        UserLibrary userLibrary = new UserLibrary();
        Integer commentId = 2;
        video = new Video(id, videoName,query, favorite, year, url, userLibrary, commentId);

    }

    @Test
    public void testCreate(){
       //given
        HttpStatus expected = HttpStatus.CREATED;
        Video expectedVideo = new Video(null, null, null, null, null, null, null, null);
        BDDMockito
                .given(service.create(expectedVideo))
                .willReturn(expectedVideo);

        //given
        ResponseEntity<Video> response = controller.create(expectedVideo);
        HttpStatus actual = (HttpStatus) response.getStatusCode();
        Video actualVideo = response.getBody();

        //then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedVideo, actualVideo);
    }

    @Test
    public void testShow(){
        //given
        HttpStatus expected = HttpStatus.OK;
        Video expectedVideo = new Video(null, null, null, null, null, null, null, null);
        BDDMockito
                .given(service.showById(expectedVideo.getVideoId()))
                .willReturn(expectedVideo);

        //given
        ResponseEntity<Video> response = controller.getVideoById(expectedVideo.getVideoId());
        HttpStatus actual = (HttpStatus) response.getStatusCode();
        Video actualVideo = response.getBody();

        //then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedVideo, actualVideo);
    }
}
