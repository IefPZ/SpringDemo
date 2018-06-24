package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private Log log = LogFactory.getLog(UserControllerTest.class);

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void addStudentTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/students/")
                        .param("id", "1")
                        .param("name", "测试大师")
                        .param("age", "20")
        )
                .andDo(print())
                .andExpect(content().string(Matchers.equalTo("success")))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        log.debug("content:" + content);
    }
}
