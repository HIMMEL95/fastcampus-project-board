package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fastcampus.projectboard.config.SecurityConfig;

@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void givenRootPath_whenRequestingRootPage_thenRedirectsToArticlesPage() throws Exception {
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

}
