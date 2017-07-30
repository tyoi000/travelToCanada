package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.Util.exception.EntityNotFoundInDBException;
import cn.celadon.travel.canada.annotations.DynamicWebEntity;
import cn.celadon.travel.canada.domin.dynamicDataModules.Article;
import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.repository.ArticleRepository;
import cn.celadon.travel.canada.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by empqqty on 6/4/2017.
 */
@Service
@Transactional
@Component
    public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @DynamicWebEntity(summaryHtmlPage = "articleSummary",templateName="article.ftl", recordNamingStrategy = "article-{0}")
    public List<Article> findAll() {
        return articleRepository.findAll();

    }

    @Override
    public void save(Article article) {

        article.setPublishTime(new Date());
        articleRepository.save(article);
    }

    @Override
    public void delete(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    @Override
    public void updateArticle(Article article) throws EntityNotFoundInDBException{

        Article existArticle = articleRepository.findById(article.getId()).get();
        if (existArticle == null){
            throw new EntityNotFoundInDBException(article);
        }

        existArticle.setTitle(article.getTitle());
        existArticle.setPublishTime(new Date());
        existArticle.setMark(article.getMark());
        existArticle.setContent(article.getContent());
        existArticle.setIntroduction(article.getIntroduction());
    }

    @Override
    public Article getArticleById(String id) {
        Article article = articleRepository.findById(Long.getLong(id)).get();
        return article;
    }

    @PostConstruct
    @Override
    public void register() {
        IWebModuleRegister.webModules.put("article",this);
    }
}
