package cn.celadon.travel.canada.service;

import freemarker.template.Template;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by empqqty on 6/23/2017.
 */
public interface IStaticPageGenerator {
    public void generateSinglePage(String pageTemplate, Object pageContent, String fileStoragePath) throws Exception;
    public void generateListSummarySinglePage(String pageTemplate, List<Object> pageContent, String fileStoragePath) throws Exception;

}
