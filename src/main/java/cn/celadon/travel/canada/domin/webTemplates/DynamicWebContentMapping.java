package cn.celadon.travel.canada.domin.webTemplates;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by empqqty on 7/18/2017.
 */

@Entity
@Table(name = "dynamic_web_content_mapping")
public class DynamicWebContentMapping {

    private long id;
    private DynamicWebContent dynamicWebContent;
    private String innerAreaMappingName;
    @Embedded
    private WebPageInfo innerAreaMappingArea;
    private int innerAreaMappingRecordNumber;

    public String getInnerAreaMappingName() {
        return innerAreaMappingName;
    }

    public void setInnerAreaMappingName(String innerAreaMappingName) {
        this.innerAreaMappingName = innerAreaMappingName;
    }


    @AttributeOverrides({@AttributeOverride(name = "pageHtmlName", column = @Column(name = "inner_html_name")),
            @AttributeOverride(name = "pageDisplayName", column = @Column(name = "inner_display_name")),
            @AttributeOverride(name = "pageTemplate", column = @Column(name = "inner_page_template"))})
    public WebPageInfo getInnerAreaMappingArea() {
        return innerAreaMappingArea;
    }

    public void setInnerAreaMappingArea(WebPageInfo innerAreaMappingArea) {
        this.innerAreaMappingArea = innerAreaMappingArea;
    }

    public int getInnerAreaMappingRecordNumber() {
        return innerAreaMappingRecordNumber;
    }

    public void setInnerAreaMappingRecordNumber(int innerAreaMappingRecordNumber) {
        this.innerAreaMappingRecordNumber = innerAreaMappingRecordNumber;
    }
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

    @OneToOne(cascade = {javax.persistence.CascadeType.REFRESH, javax.persistence.CascadeType.DETACH}, optional = false, fetch = FetchType.EAGER,  targetEntity = DynamicWebContent.class)
    @JoinColumn(name="dynamic_module_id")
    public DynamicWebContent getDynamicWebContent() {
        return dynamicWebContent;
    }

    public void setDynamicWebContent(DynamicWebContent dynamicWebContent) {
        this.dynamicWebContent = dynamicWebContent;
    }
}
