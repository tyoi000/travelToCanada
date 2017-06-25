package cn.celadon.travel.canada.dao.UtilTest;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by empqqty on 6/19/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class TestFreeMarker {
    @Test
    public void testFreeMarker() throws Exception{

        freemarker.template.Version version = new freemarker.template.Version(2,3,1);
        Configuration cfg = new Configuration(version);
            cfg.setDirectoryForTemplateLoading(new File(TestFreeMarker.this.getClass().getResource("/").getPath()));
        cfg.setObjectWrapper(new DefaultObjectWrapper(version));
        Template temp = cfg.getTemplate("person.ftl");
        Map root = new HashMap();
        root.put("name", "张三");
        root.put("address", "中国-北京");
        Writer out = new OutputStreamWriter(new FileOutputStream(TestFreeMarker.this.getClass().getResource("/").getPath()+"lala.html"));
        temp.process(root, out);

    }
}
