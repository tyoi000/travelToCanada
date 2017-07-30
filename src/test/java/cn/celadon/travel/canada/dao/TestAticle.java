package cn.celadon.travel.canada.dao;

import cn.celadon.travel.canada.service.Impl.WebNodeServiceImpl;
import cn.celadon.travel.canada.web.NewsController;
import cn.celadon.travel.canada.domin.dynamicDataModules.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

/**
 * Created by empqqty on 6/1/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestAticle {

    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Autowired
    NewsController newsController;

    @Autowired
    WebNodeServiceImpl webNodeService;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void testAddArticle(){
        Article example = new Article();
        example.setAuthor("Yi");
        example.setClickCount(5);
        example.setContent("wowowowowowowwwwwwwwwwwwwwww");
        example.setIntroduction("hello world!");
        example.setMark("news");
        example.setPublishTime(new Date());
        example.setTitle("HI");
        String uri = "/news/add";
        try {
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,uri,example).accept(MediaType.APPLICATION_JSON)).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        newsController.addUser(example);
    }

    @Test
    public void testFindAllArticles(){
        String uri = "/news/";
        try {
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
            System.out.print("The out put data is " + mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testUpdateArticle(){

    }
}
