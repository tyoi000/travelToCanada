package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.service.IStaticPageGenerator;
import cn.celadon.travel.canada.service.ITemplateProvider;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by empqqty on 6/25/2017.
 */
@Service
public class StaticPageGeneratorImpl implements IStaticPageGenerator {
    @Autowired
    private ITemplateProvider templateProvider;

    @Override
    public void generateSinglePage(String pageTemplate, Object pageContent, String fileStoragePath) throws Exception {

            Template loadedTemplate = templateProvider.loadTemplate(pageTemplate);
            Writer out = new OutputStreamWriter(new FileOutputStream(fileStoragePath), "UTF-8");
            loadedTemplate.process(pageContent, out);
    }

    @Override
    public void generateListSummarySinglePage(String pageTemplate, List<Object> pageContent, String fileStoragePath) {
    }

    @Override
    public void generateJsFile(String pageTemplate, Object pageContent, String fileStoragePath) throws Exception {

    }
}
