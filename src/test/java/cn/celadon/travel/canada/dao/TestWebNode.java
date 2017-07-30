package cn.celadon.travel.canada.dao;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.domin.webTemplates.WebNodeType;
import cn.celadon.travel.canada.service.Impl.WebNodeServiceImpl;
import cn.celadon.travel.canada.view.WebNodeTree;
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

import java.util.Date;
import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestWebNode {
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Autowired
    WebNodeServiceImpl webNodeService;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
        //webNodeService.deleteAllWebNodes();
    }

    @Test
    public void testAddWebNode(){
        WebNode testNode = new WebNode();
        testNode.setCreateTime(new Date());
        testNode.setDisplayName("首页");
        //testNode.setHtmlLink("studyAboard.html");
        testNode.setNodeType(WebNodeType.NAV_NODE);
        webNodeService.addWebNode(testNode);
    }

    @Test
    public void testAddWebNodeWithParentNode(){
        List<WebNode> webNodes = webNodeService.findAllWebNodes();
        int index = 0;
        for (WebNode singleNode: webNodes){
            index++;
            WebNode testNode = new WebNode();
            testNode.setCreateTime(new Date());
            testNode.setDisplayName("首页" + index);
            //testNode.setHtmlLink("studyAboard.html");
            testNode.setNodeType(WebNodeType.NAV_NODE);
            testNode.setParentNode(singleNode);
            webNodeService.addWebNode(testNode);
        }
    }

    @Test
    public void testRemoveParentNode(){
        webNodeService.deleteWebNode(new Long(3));
        // for JPA AIP, the cascaded remove not work for @ManyToOne relationship
    }

    @Test
    public void testQueryData(){
        List<WebNode> webNodes = webNodeService.findAllWebNodes();
        for (WebNode singleNode: webNodes){
            System.out.print(singleNode.getParentNode()==null?"no parent id":singleNode.getParentNode().toString());
        }
    }

    @Test
    public void testWebNodeTree(){
       WebNodeTree root =  webNodeService.getTreeStructure();
        System.out.print("this is for test");
    }
}
