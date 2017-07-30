package cn.celadon.travel.canada.domin;

import javax.persistence.Transient;

/**
 * Created by empqqty on 7/12/2017.
 */
public class EntityBaseHtml {
    @Transient
    private String htmlLink;

    @Transient
    private int pageNumber;

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
