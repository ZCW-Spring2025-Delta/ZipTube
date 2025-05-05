package ZCWDelta.ZipTube.controllers;


import ZCWDelta.ZipTube.models.Video;
import ZCWDelta.ZipTube.repos.VideoRepo;
import ZCWDelta.ZipTube.services.VideoService;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@WebMvcTest(VideoController.class)
public class VideoControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockitoBean
    private VideoService Service;

    @Test
    public void testShowById() throws Exception {
        Integer givenId = 1;
        Video video = new Video(givenId, "Spring Boot", null, true, "2023", "https://youtu.be/x", null, null);
        BDDMockito
                .given(Service.showById(givenId))
                .willReturn(video);

//        String expectedContent = "{\"id\":null,\"videoName\":\"movie-name\",\"query\":null,\"favorite\":null,\"year\":null,\"url\":null,\"specialty\":null}";
        this.mvc.perform(get("/video/" + givenId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.videoName").value("Spring Boot"));
    }

    @Test
    public void testCreate() throws Exception {
        Video video = new Video(1, "Sample", null, false, "2024", "url", null, null);
        BDDMockito.given(Service.create(BDDMockito.any())).willReturn(video);

        mvc.perform(post("/video/")
                        .content("{\"videoName\": \"Sample\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
