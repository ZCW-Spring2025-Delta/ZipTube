package ZCWDelta.ZipTube.models;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class VideoTest {

    private Video video;

    @BeforeEach
    public void setUp(){
        Integer id = 1;
        String videoName = "movie of the year";
        String query = "documentary";
        Boolean favorite = true;
        String year = "12-11-2022";
        String url = "www.hereisthevideo.com";
        Integer userId = 3;
        Integer commentId = 2;
      video = new Video(id, videoName,query, favorite, year, url, userId, commentId);
    }
    @Test
    public void testGettersAndSettersId(){
        //given

    //when
        Integer actualId = video.getVideoId();
        Integer expectedId = 1;

    //Then
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testGettersAndSettersName(){
        //given
        video.setVideoName("Gine in 60 seconds");
        //when
        String actualString = video.getVideoName();
        String expectedString = "Gine in 60 seconds";
        //when;

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGettersAndSettersQuery(){
        //given
        video.setQuery("action");
        //when
        String actualString = video.getQuery();
        String expectedString = "action";
        //when;

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGettersAndSettersFavorite(){
        //given
        video.setVideoName("Gine in 60 seconds");
        //when
        Boolean actualString = video.getFavorite();
        //when;

        //Then
        Assertions.assertTrue(actualString);
    }

    @Test
    public void testGettersAndSettersUrl(){
        //given
        //when
        String actualString = video.getURL();

        //when;

        //Then
        Assert.assertEquals("www.hereisthevideo.com", actualString);
    }
}
