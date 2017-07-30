package cn.celadon.travel.canada.domin.webTemplates;

import javax.persistence.Embeddable;

/**
 * Created by empqqty on 7/12/2017.
 */
@Embeddable
public class WebPageInfo {
    private String pageDisplayName;
    private String pageHtmlName;
    private String pageTemplate;

    public String getPageHtmlName() {
        return pageHtmlName;
    }

    public void setPageHtmlName(String pageHtmlName) {
        this.pageHtmlName = pageHtmlName;
    }

    public String getPageTemplate() {
        return pageTemplate;
    }

    public void setPageTemplate(String pageTemplate) {
        this.pageTemplate = pageTemplate;
    }

    // this might not be used and please be careful
    public String getPageDisplayName() {
        return pageDisplayName;
    }

    public void setPageDisplayName(String pageDisplayName) {
        this.pageDisplayName = pageDisplayName;
    }
}
