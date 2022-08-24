package com.fastcampus.projectboard.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
    LocalDateTime createdAt,
    String createdBy,
    String title,
    String content,
    String hashtag
) implements Serializable {
    
}
