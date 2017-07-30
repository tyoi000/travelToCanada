package cn.celadon.travel.canada;

import cn.celadon.travel.canada.service.IAchievementService;
import cn.celadon.travel.canada.service.IArticleService;
import cn.celadon.travel.canada.service.ISchoolInformationService;
import cn.celadon.travel.canada.service.IWebPageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;

/**
 * Created by empqqty on 5/11/2017.
 */
@SpringBootApplication
@EnableCaching
public class Application extends SpringBootServletInitializer {

    @Value("${static.page.output.path}")
    private String storagePath = "/";

    @Autowired
    private IWebPageGenerator pageGenerator;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ISchoolInformationService schoolInformationService;

    @Autowired
    private IAchievementService achievementService;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init(){
        pageGenerator.generateAllAvailableWebPages();
    }
}
