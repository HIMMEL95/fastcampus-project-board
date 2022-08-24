package com.fastcampus.projectboard.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.repository.ArticleRepository;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;
    
    // 각 게시글 페이지로 이동
    // 페이지네이션
    // 홈 버튼->
    // 게시판 페이지로 리다이렉션
    // 정렬 기능

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        // Given

        // When
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");  // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
    }
}
