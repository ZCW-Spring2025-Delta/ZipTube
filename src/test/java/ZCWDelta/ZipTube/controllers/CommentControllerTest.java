package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.models.Comment;
import ZCWDelta.ZipTube.repos.CommentRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;

@SpringBootTest
public class CommentControllerTest {

    @Autowired
    private MockMvc mvc;

    private CommentRepo repo;

    //may need to wait until H2DB gets set up for tests to run
    @Test //getmapping by id
    public void testShowComment() throws Exception {
        Integer givenId = 1;
        BDDMockito
                .given(repo.findById(givenId))
                .willReturn(Optional.of(new Comment("string", null, null)));

        String expectedString = "{\"id\":null,\"text\":string,\"userId\":null,\"videoId\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/comments/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedString));
    }

//    @Test //getmapping all
//    public void testShowAllComments() {
//
//    }

//    @Test //postmapping
//    public void testCreateComment() throws Exception {
//        Comment comment = new Comment("Comment text", null, null);
//        BDDMockito
//                .given(repo.save(comment))
//                .willReturn(comment);
//
//        String expectedString = "{\"id\":null,\"text\":Comment text,\"userId\":null,\"videoId\":null}";
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/comment/")
//                .content(expectedString)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//            )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedString));
//    }
    //get mapping by user id
    //getmapping by video id

    //deletemapping by id
    //deletemapping by user id
    //deletemapping by video id

}
