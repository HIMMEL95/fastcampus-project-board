package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fastcampus.projectboard.config.SecurityConfig;

@DisplayName("View 컨트롤러 - 인증")
@Import(SecurityConfig.class)
@WebMvcTest
public class AuthControllerTest {
    
    private final MockMvc mvc;

	public AuthControllerTest(@Autowired MockMvc mvc) { // 테스트에는 꼭 @Autowired annotation 붙여줘야 된다.
		this.mvc = mvc;
	}

    @DisplayName("[view][GET] 로그인 페이지 - 정상 호출")
	@Test
	public void givenNothing_whenTryingToLogIn_thenReturnsLogInView() throws Exception {
		// Given

		// When & Then
		mvc.perform(MockMvcRequestBuilders.get("/login"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
}
