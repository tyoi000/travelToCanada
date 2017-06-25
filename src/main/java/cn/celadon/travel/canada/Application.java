package cn.celadon.travel.canada;

import cn.celadon.travel.canada.domin.Article;
import cn.celadon.travel.canada.service.IArticleService;
import cn.celadon.travel.canada.service.IStaticPageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by empqqty on 5/11/2017.
 */
@SpringBootApplication
@EnableCaching
public class Application extends SpringBootServletInitializer {

    @Value("${static.page.output.path}")
    private  String storagePath = "/";

    @Autowired
    private  IStaticPageGenerator staticPageGenerator;

    @Autowired
    private IArticleService articleService;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init(){
        try {
            storagePath = ResourceUtils.getURL(storagePath).getPath();
            List<Article> articles = articleService.findAll();
            for (Article article : articles){
                Map mapList = new HashMap();
                mapList.put("webTitle","飞跃加拿大");
                mapList.put("article",article);
                String filePath = storagePath +"/" + article.getId() + ".html";
                File file = new File(filePath);
                file.createNewFile();
                staticPageGenerator.generateSinglePage("article.ftl",mapList,filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
