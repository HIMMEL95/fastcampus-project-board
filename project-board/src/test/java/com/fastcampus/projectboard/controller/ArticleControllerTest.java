package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

import com.fastcampus.projectboard.config.SecurityConfig;

@DisplayName("View 컨트롤러 - 게시글")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleController.class) // 해당 컨트롤러만 인식해서 테스트하게 된다.
public class ArticleControllerTest {

	private final MockMvc mvc;

	public ArticleControllerTest(@Autowired MockMvc mvc) { // 테스트에는 꼭 @Autowired annotation 붙여줘야 된다.
		this.mvc = mvc;
	}

	@DisplayName("[view][GET] 게시글 리스트 {게시판} 페이지 - 정상 호출")
	@Test
	public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
		// Given

		// When & Then
		mvc.perform(MockMvcRequestBuilders.get("/articles"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				.andExpect(MockMvcResultMatchers.view().name("articles/index"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("articles"));
	}

	@DisplayName("[view][GET] 게시글 상세 페이지 - 정상 호출")
	@Test
	public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
		// Given

		// When & Then
		mvc.perform(MockMvcRequestBuilders.get("/articles/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				.andExpect(MockMvcResultMatchers.view().name("articles/detail"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("article"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("articleComments"));
	}

	@Disabled("구현중")
	@DisplayName("[view][GET] 게시글 검색 전용 페이지 - 정상 호출")
	@Test
	public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
		// Given

		// When & Then
		mvc.perform(MockMvcRequestBuilders.get("/articles/search"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				.andExpect(MockMvcResultMatchers.model().attributeExists("articles/search"));
	}

	@Disabled("구현중")
	@DisplayName("[view][GET] 게시글 해시태그 검색 페이지 - 정상 호출")
	@Test
	public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView()
			throws Exception {
		// Given

		// When & Then
		mvc.perform(MockMvcRequestBuilders.get("/articles/search-hashtag"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				.andExpect(MockMvcResultMatchers.model().attributeExists("articles/search-hashtag"));
	}

}
