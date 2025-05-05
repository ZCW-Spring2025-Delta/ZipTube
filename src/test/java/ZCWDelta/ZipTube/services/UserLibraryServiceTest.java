package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.ZipTubeApplication;
import ZCWDelta.ZipTube.controllers.UserLibraryController;
import ZCWDelta.ZipTube.controllers.VideoController;
import ZCWDelta.ZipTube.models.User;
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

import java.util.List;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ZipTubeApplication.class)
public class UserLibraryServiceTest {

    private UserLibrary userLibrary;
    @Mock
    private UserLibraryService userLibraryService;
    @InjectMocks
    public UserLibraryController controller;

    @BeforeEach
    public void setUp(){
        this.controller = new UserLibraryController(userLibraryService);
        //userLibrary = new UserLibrary(1, )

    }

    @Test
    public void testCreate(){
        //given
        HttpStatus expected = HttpStatus.CREATED;
        UserLibrary expectedUserLibrary = new UserLibrary(null, null, null, null, null);
        BDDMockito
                .given(userLibraryService.create(expectedUserLibrary))
                .willReturn(expectedUserLibrary);

        //given
        ResponseEntity<UserLibrary> response = controller.create(expectedUserLibrary);
        HttpStatus actual = (HttpStatus) response.getStatusCode();
        UserLibrary actualUserLibrary = response.getBody();

        //then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedUserLibrary, actualUserLibrary);
    }

   // @Test
//    public void testShow(){
//        //given
//        HttpStatus expected = HttpStatus.OK;
//        UserLibrary expectedUserLibrary = new UserLibrary(null, null, null, null, null);
//        BDDMockito
//                .given(userLibraryService.showAllUploads(expectedUserLibrary.getId(), new User()))
//                .willReturn((List<Video>) expectedUserLibrary);
//
//        //given
//        ResponseEntity<Iterable<Video>> response = controller.getAllUploads(expectedUserLibrary.getVideoId(), new User());
//        HttpStatus actual = (HttpStatus) response.getStatusCode();
//        Video expectUserLibrary = (Video) response.getBody();
//
//        //then
//        Assert.assertEquals(expected, actual);
//        Assert.assertEquals(expectedUserLibrary, expectUserLibrary);
//    }
}
