package com.dminers.pharmabi.internalprods.repositories;

import com.dminers.pharmabi.internalprods.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
