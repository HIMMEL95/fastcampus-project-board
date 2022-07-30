package com.fastcampus.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;

@RepositoryRestResource
public interface ArticleRepository extends
		JpaRepository<Article, Long>,
		QuerydslPredicateExecutor<Article>, /// Entity가 들어가게 된다. Article에 있는 모든 기본 검색기능 추가
		QuerydslBinderCustomizer<QArticle> // Entity path가 들어가게 된다 . 여기에 Qclass가 들어가야
// 된다.
{

	@Override
	default void customize(QuerydslBindings bindings, QArticle root) {
		bindings.excludeUnlistedProperties(true);
		bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
		// bindings.bind(root.title).first(StringExpression::likeIgnoreCase); like '{v}'
		bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
		bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}%'
		bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
		bindings.bind(root.createdAt).first(DateTimeExpression::eq); // 이것은 완전히 같은 문자열을 검색하는 것이기 때문에 eq로 작성한다.
		bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
	}

}
