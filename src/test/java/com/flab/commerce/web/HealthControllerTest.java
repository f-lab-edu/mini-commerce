package com.flab.commerce.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ok_test() throws Exception {
        mockMvc.perform(get("/ok"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("ok"));
    }

    @Test
    public void hello_test() throws Exception {
        String hello = "hello";

        mockMvc.perform(get("/hello").param("hello", hello))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(hello));
    }
}