package com.fastcampus.projectboard.service;

import org.springframework.stereotype.Service;

import com.fastcampus.projectboard.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArticleService {
    
    private final ArticleRepository articleRepository;
    
}
