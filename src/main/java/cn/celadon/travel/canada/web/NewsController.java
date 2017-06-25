package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.domin.Article;
import cn.celadon.travel.canada.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by empqqty on 6/1/2017.
 */
@RestController
@RequestMapping( value = "/news")
public class NewsController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value="/")
    @ResponseBody
    public List<Article> getNewsList(){

        List<Article> articles = articleService.findAll();
        return articles;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public Object addUser(@RequestBody Article articleEntity)
    {
        articleService.save(articleEntity);
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "a good response");
        return resultMsg;
    }

    @RequestMapping(value="/hi")
    @ResponseBody
    public String getArticle(String articleId){
         Article article = articleService.getArticleById(articleId);
        return "";
    }
}
