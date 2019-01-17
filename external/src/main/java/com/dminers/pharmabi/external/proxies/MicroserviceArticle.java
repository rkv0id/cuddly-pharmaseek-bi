package com.dminers.pharmabi.external.proxies;

import com.dminers.pharmabi.external.beans.ArticleBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "internalprods", url = "localhost:8090")
public interface MicroserviceArticle {

    @GetMapping(value = "/articles")
    List<ArticleBean> listeDesArticles();

    @GetMapping(value = "/articles/{id}")
    Resource<ArticleBean> getById(@PathVariable("id") int id);

}
