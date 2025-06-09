//package ZCWDelta.ZipTube.controllers;
//
//
//import ZCWDelta.ZipTube.VideoDTO;
//import ZCWDelta.ZipTube.models.Video;
//import ZCWDelta.ZipTube.services.VideoService;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//@WebMvcTest(VideoController.class)
//public class VideoControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//
//    @MockitoBean
//    private VideoService service;
//
//    @Test
//    public void testShowById() throws Exception {
//        Integer givenId = 1;
//        Video video = new Video(givenId, "Spring Boot", null, true, true, "2023", "https://youtu.be/x", null, null);
//        BDDMockito
//                .given(service.getVideoById(givenId))
//                .willReturn(Optional.of(video));
//
////        String expectedContent = "{\"id\":null,\"videoName\":\"movie-name\",\"query\":null,\"favorite\":null,\"year\":null,\"url\":null,\"specialty\":null}";
//        this.mvc.perform(get("/video/" + givenId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.videoName").value("Spring Boot"));
//    }
//
//    @Test
//    void testGetVideoById_found() throws Exception {
//        Video video = new Video(1, "Spring Boot", null, true, true, "2023", "url", null, null);
//        BDDMockito.given(service.getVideoById(1)).willReturn(Optional.of(video));
//
//        mvc.perform(get("/video/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.videoName").value("Spring Boot"));
//    }
//    @Test
//    void testGetVideoById_notFound() throws Exception {
//        BDDMockito.given(service.getVideoById(99)).willReturn(null);
//
//        mvc.perform(get("/video/99"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testCreateVideo() throws Exception {
//        Video input = new Video(null, "Create Test", null, false, false, "2024", "url", null, null);
//        Video saved = new Video(5, "Create Test", null, false,false, "2024", "url", null, null);
//
//        BDDMockito.given(service.createVideo(any(VideoDTO.class),"name" )).willReturn(saved);
//
//        String requestBody = """
//            {
//              "videoName": "Create Test",
//              "favorite": false,
//              "year": "2024",
//              "url": "url"
//            }
//            """;
//
//        mvc.perform(post("/video")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.videoId").value(5))
//                .andExpect(jsonPath("$.videoName").value("Create Test"));
//    }
//
//    @Test
//    public void testGetAllVideos() throws Exception {
//        Video v1 = new Video(1, "Test 1", null, false, false, "2022", "url1", null, null);
//        Video v2 = new Video(2, "Test 2", null, true, true, "2023", "url2", null, null);
//
//        BDDMockito.given(service.showAll()).willReturn(Arrays.asList(v1, v2));
//
//        mvc.perform(get("/video"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].videoName").value("Test 1"))
//                .andExpect(jsonPath("$[1].videoName").value("Test 2"));
//    }
//
//    @Test
//    void testUpdateVideo() throws Exception {
//        Video updated = new Video(1, "Updated", null, true, true, "2025", "url", null, null);
//        BDDMockito.given(service.update(BDDMockito.eq(1), any())).willReturn(updated);
//
//        String updateJson = """
//            {
//              "videoId": 1,
//              "videoName": "Updated",
//              "favorite": true,
//              "year": "2025",
//              "url": "url"
//            }
//            """;
//
//        mvc.perform(put("/video")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(updateJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.videoName").value("Updated"));
//    }
//
//    @Test
//    void testDeleteVideo() throws Exception {
//        mvc.perform(delete("/video/1"))
//                .andExpect(status().isOk());
//    }
//}
