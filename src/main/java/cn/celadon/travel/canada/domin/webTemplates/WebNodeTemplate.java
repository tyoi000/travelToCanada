package cn.celadon.travel.canada.domin.webTemplates;

import cn.celadon.travel.canada.domin.WebNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by empqqty on 6/18/2017.
 */
public class WebNodeTemplate {
    private String templateHtmlPath;
    private List<String> templateContent;
    private List<String> attributesName;

    public WebNodeTemplate(String templateHtmlPath) throws IOException {
        this.templateHtmlPath = templateHtmlPath;
        Path filePath = Paths.get(this.getClass().getResource(templateHtmlPath).getPath());
        templateContent = Files.readAllLines(filePath);
    }

    public String getTemplateHtmlPath() {
        return templateHtmlPath;
    }

    public void setTemplateHtmlPath(String templateHtmlPath) {
        this.templateHtmlPath = templateHtmlPath;
    }

    public List<String> getAttributesName() {
        return attributesName;
    }

    public void setAttributesName(List<String> attributesName) {
        this.attributesName = attributesName;
    }
}
