package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.Util.exception.LogicalException;
import cn.celadon.travel.canada.domin.Article;

import java.util.*;

/**
 * Created by empqqty on 6/4/2017.
 */
public interface IArticleService {
    public List<Article> findAll();
    public void save(Article article);
    public void delete(Long articleId);
    public void updateArticle(Article article) throws LogicalException;
    public Article getArticleById(String id);


}
