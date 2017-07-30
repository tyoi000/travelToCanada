package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.service.ITemplateProvider;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by empqqty on 6/23/2017.
 */
@Service
public class TemplateProviderImpl implements ITemplateProvider {

    @Autowired
    Configuration configuration;

    @Override
    public void loadTemplates() {
    }

    @Override
    public Template loadTemplate(String templateName) throws IOException {
        configuration.setDateFormat("yyyy-MM-dd");
        return configuration.getTemplate(templateName);
    }

    @Override
    public void reloadTemplates() {
        configuration.clearTemplateCache();
    }
}
