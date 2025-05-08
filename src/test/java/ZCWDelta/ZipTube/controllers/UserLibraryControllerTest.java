//package ZCWDelta.ZipTube.controllers;
//
//import ZCWDelta.ZipTube.models.UserLibrary;
//import ZCWDelta.ZipTube.services.UserLibraryService;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.List;
//
//@WebMvcTest(UserLibraryController.class)
//public class UserLibraryControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockitoBean
//    private UserLibraryService service;
//
//    @Test
//    public void testGetUserLibraryById_found() throws Exception{
//        UserLibrary userLibrary = new UserLibrary(1, List.of(), List.of(), 101, 102);
//
//        BDDMockito.given(service.showById(1)).willReturn(userLibrary);
//
//        mvc.perform(get("/library/favorites"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("userId").value(101));
//    }
//
//    @Test
//    void testGetUserLibraryById_notFound() throws Exception {
//        BDDMockito.given(service.showById(99)).willReturn(null);
//
//        mvc.perform(get("/library/99"))
//                .andExpect(status().isNotFound());
//    }
//
//}
