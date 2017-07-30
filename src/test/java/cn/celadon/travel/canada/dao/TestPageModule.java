package cn.celadon.travel.canada.dao;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.domin.webTemplates.WebNodeType;
import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContent;
import cn.celadon.travel.canada.domin.webTemplates.PageModule;
import cn.celadon.travel.canada.domin.webTemplates.WebPageInfo;
import cn.celadon.travel.canada.repository.DynamicWebContentRepository;
import cn.celadon.travel.canada.repository.WebNodeRepository;
import cn.celadon.travel.canada.service.IPageModuleService;
import cn.celadon.travel.canada.service.IWebPageGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by empqqty on 7/6/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestPageModule {

    MockMvc mvc;

    @Autowired
    WebNodeRepository webNodeRepository;

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Autowired
    IPageModuleService pageModuleService;

    @Autowired
    IWebPageGenerator webPageGenerator;

    @Autowired
    DynamicWebContentRepository dynamicWebContentRepository;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }


    @Test
    public void addArticleDynamicModule(){
        DynamicWebContent dynamicWebContent = new DynamicWebContent();
        dynamicWebContent.setDynamicEntityMapping("article");
        dynamicWebContent.setInnerAreaType(WebNodeType.DYNAMIC_INNER_AREA);
        WebPageInfo summaryPage = new WebPageInfo();
        summaryPage.setPageHtmlName("articleSummary");
        summaryPage.setPageTemplate("news_page.ftl");
        summaryPage.setPageDisplayName("新闻热点");

        WebPageInfo entityPage = new WebPageInfo();
        entityPage.setPageDisplayName("新闻");
        entityPage.setPageTemplate("article.ftl");
        entityPage.setPageHtmlName("article-{0}");
        dynamicWebContent.setEntityPage(entityPage);
        dynamicWebContent.setSummaryPage(summaryPage);
        dynamicWebContent.setEntityFilterType("");
        dynamicWebContentRepository.save(dynamicWebContent);
    }


    @Test
    public void addDynamicModules(){
        addSchoolDynamicModule();
        addAchievementDynamic();
    }

    public void addSchoolDynamicModule(){
        DynamicWebContent dynamicWebContent = new DynamicWebContent();
        dynamicWebContent.setDynamicEntityMapping("schoolInfo");
        dynamicWebContent.setInnerAreaType(WebNodeType.DYNAMIC_INNER_AREA);
        WebPageInfo summaryPage = new WebPageInfo();
        summaryPage.setPageHtmlName("SchoolSummary");
        summaryPage.setPageTemplate("news_page.ftl");
        summaryPage.setPageDisplayName("热门大学");

        WebPageInfo entityPage = new WebPageInfo();
        entityPage.setPageDisplayName("大学");
        entityPage.setPageTemplate("schoolInfo.ftl");
        entityPage.setPageHtmlName("schoolInfo-{0}");
        dynamicWebContent.setEntityPage(entityPage);
        dynamicWebContent.setSummaryPage(summaryPage);
        dynamicWebContent.setEntityFilterType("");
        dynamicWebContentRepository.save(dynamicWebContent);
    }


    public void addAchievementDynamic(){
        DynamicWebContent dynamicWebContent = new DynamicWebContent();
        dynamicWebContent.setDynamicEntityMapping("achievement");
        dynamicWebContent.setInnerAreaType(WebNodeType.DYNAMIC_INNER_AREA);
        WebPageInfo summaryPage = new WebPageInfo();
        summaryPage.setPageHtmlName("achievementSummary");
        summaryPage.setPageTemplate("news_page.ftl");
        summaryPage.setPageDisplayName("成功案例");

        WebPageInfo entityPage = new WebPageInfo();
        entityPage.setPageDisplayName("案例");
        entityPage.setPageTemplate("achievement.ftl");
        entityPage.setPageHtmlName("achievement-{0}");
        dynamicWebContent.setEntityPage(entityPage);
        dynamicWebContent.setSummaryPage(summaryPage);
        dynamicWebContent.setEntityFilterType("");
        dynamicWebContentRepository.save(dynamicWebContent);
    }

    @Test
    public void testAddPageContent(){

        PageModule indexPage = new PageModule();
        indexPage.setName("首页");
        indexPage.setActive(true);
        indexPage.setCreateDate(new Date());
        WebPageInfo pageInfo = new WebPageInfo();
        pageInfo.setPageHtmlName("index_static");
        pageInfo.setPageTemplate("index.ftl");
        indexPage.setPageInfo(pageInfo);

        DynamicWebContent dynamicWebContent = new DynamicWebContent();
        dynamicWebContent.setDynamicEntityMapping("article");
        dynamicWebContent.setEntityFilterType(null);
        //dynamicWebContent.setInnerAreaMappingName("area1");
        //dynamicWebContent.setInnerAreaMappingRecordNumber(5);
        WebPageInfo entityPage = new WebPageInfo();
        entityPage.setPageHtmlName("article-{0}");
        entityPage.setPageTemplate("article.ftl");
        dynamicWebContent.setEntityPage(entityPage);

        WebPageInfo summaryPage = new WebPageInfo();
        summaryPage.setPageTemplate("news_page.ftl");
        summaryPage.setPageHtmlName("news_summary");
        dynamicWebContent.setSummaryPage(summaryPage);

        WebPageInfo innerArea = new WebPageInfo();
        //dynamicWebContent.setInnerAreaMappingArea(innerArea);

        dynamicWebContent.setInnerAreaType(WebNodeType.DYNAMIC_INNER_AREA);
        List<DynamicWebContent> dynamicWebList = new ArrayList<>();
        dynamicWebList.add(dynamicWebContent);
        //indexPage.setDynamicWebContentList(dynamicWebList);
        pageModuleService.addPageModule(indexPage);
    }


    @Test
    public void testAddOtherPageContent(){

        PageModule indexPage = new PageModule();
        indexPage.setName("企业理念");
        indexPage.setActive(true);
        indexPage.setCreateDate(new Date());
        WebPageInfo pageInfo = new WebPageInfo();
        pageInfo.setPageHtmlName("industryTheory");
        pageInfo.setPageTemplate("second_level.ftl");
        indexPage.setPageInfo(pageInfo);
        pageModuleService.addPageModule(indexPage);
    }

    @Test
    public void testPageModuleTree(){
       // PageModuleTree pageModuleTree = pageModuleService.findPageTree();
        //System.out.print(pageModuleTree.getChildPages().size());
    }

    @Test
    public void testGenerator(){
        webPageGenerator.generateAllAvailableWebPages();
    }

    @Test
    public void testUpdatePageModule(){
        PageModule updateModule = pageModuleService.findPageWithId(4L);
        updateModule.getPageInfo().setPageHtmlName("industryXXX");
        pageModuleService.updatePageModule(updateModule);
    }

    @Test
    public void testChildNodeQuery(){
        WebNode parentNode = webNodeRepository.getOne(3L);
        List<WebNode> childNodes = webNodeRepository.findChildNodes(parentNode);
        System.out.print(childNodes.size());
    }
}
