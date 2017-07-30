package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.Util.exception.LogicalException;
import cn.celadon.travel.canada.domin.dynamicDataModules.Article;
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
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add article succeed");
        return resultMsg;
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public Object deleteArticle(@RequestParam(value = "id") String articleId){
        articleService.delete(Long.parseLong(articleId));
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Delete article succeed");
        return resultMsg;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Object updateArticle(@RequestBody Article articleEntity)
    {   ResultMsg resultMsg = null;
        try {
            articleService.updateArticle(articleEntity);
            resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add article succeed");

        } catch (LogicalException e) {
            resultMsg = new ResultMsg(ResultCode.ERROR, "Update Article failed");
        }
        return resultMsg;
    }
}
