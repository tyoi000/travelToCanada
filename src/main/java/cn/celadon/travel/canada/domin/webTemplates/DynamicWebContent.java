package cn.celadon.travel.canada.domin.webTemplates;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by empqqty on 7/5/2017.
 */
@Entity
@Table( name = "dynamic_web_module")
public class DynamicWebContent {
    private long id;
    private String dynamicEntityMapping;
    private String entityFilterType;
    @Embedded
    private WebPageInfo summaryPage;
    @Embedded
    private WebPageInfo entityPage;
    private WebNodeType innerAreaType;

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDynamicEntityMapping() {
        return dynamicEntityMapping;
    }

    public void setDynamicEntityMapping(String dynamicEntityMapping) {
        this.dynamicEntityMapping = dynamicEntityMapping;
    }

    public String getEntityFilterType() {
        return entityFilterType;
    }

    public void setEntityFilterType(String entityFilterType) {
        this.entityFilterType = entityFilterType;
    }

    @AttributeOverrides({@AttributeOverride(name = "pageHtmlName", column = @Column(name = "summary_html_name")),
            @AttributeOverride(name = "pageDisplayName", column = @Column(name = "summary_display_name")),
            @AttributeOverride(name = "pageTemplate", column = @Column(name = "summary_page_template"))})
    public WebPageInfo getSummaryPage() {
        return summaryPage;
    }

    public void setSummaryPage(WebPageInfo summaryPage) {
        this.summaryPage = summaryPage;
    }

    @AttributeOverrides({@AttributeOverride(name = "pageHtmlName", column = @Column(name = "entity_html_name")),
            @AttributeOverride(name = "pageDisplayName", column = @Column(name = "entity_display_name")),
            @AttributeOverride(name = "pageTemplate", column = @Column(name = "entity_page_template"))})
    public WebPageInfo getEntityPage() {
        return entityPage;
    }

    public void setEntityPage(WebPageInfo entityPage) {
        this.entityPage = entityPage;
    }

    public WebNodeType getInnerAreaType() {
        return innerAreaType;
    }

    public void setInnerAreaType(WebNodeType innerAreaType) {
        this.innerAreaType = innerAreaType;
    }

}
