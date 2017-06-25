package cn.celadon.travel.canada.service;

import freemarker.template.Template;

import java.io.IOException;

/**
 * Created by empqqty on 6/23/2017.
 */
public interface ITemplateProvider {

    public void loadTemplates();
    public Template loadTemplate(String templateName) throws IOException;
    public void reloadTemplates();

}
