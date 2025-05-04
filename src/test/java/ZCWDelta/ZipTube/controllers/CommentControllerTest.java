package ZCWDelta.ZipTube.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.context.junit4.SpringRunner;
import ZCWDelta.ZipTube.repos.CommentRepo;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CommentRepo repo;

    //getmapping all
    //getmapping by id
    //get mapping by user id
    //getmapping by video id

    //postmapping

    //deletemapping by id
    //deletemapping by user id
    //deletemapping by video id

}
