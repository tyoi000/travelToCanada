package cn.celadon.travel.canada.domin.webTemplates;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by empqqty on 6/30/2017.
 */
@Entity
@Table( name = "page_module")
public class PageModule {
    private Long id;
    private String name;
    private String staticContent;
    private String staticContentMappingName;
    private WebNodeType type;
    private List<DynamicWebContentMapping> dynamicWebContentMappingList;
    private Date createDate;
    private boolean active;
    private int version;
    @Embedded
    private WebPageInfo pageInfo;
    private List<VisitPathTracker> visitPath;
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "page_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column( name = "static_content", length = 4000)
    public String getStaticContent() {
        return staticContent;
    }

    public void setStaticContent(String staticContent) {
        this.staticContent = staticContent;
    }

    @Column ( name = "page_type")
    public WebNodeType getType() {
        return type;
    }

    public void setType(WebNodeType type) {
        this.type = type;
    }

    @Column( name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column( name = "is_active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column( name = "page_version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "static_content_mapping_name")
    public String getStaticContentMappingName() {
        return staticContentMappingName;
    }

    public void setStaticContentMappingName(String staticContentMappingName) {
        this.staticContentMappingName = staticContentMappingName;
    }


    @Transient
    public List<VisitPathTracker> getVisitPath() {
        return visitPath;
    }

    public void setVisitPath(List<VisitPathTracker> visitPath) {
        this.visitPath = visitPath;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,  targetEntity = DynamicWebContentMapping.class)
    @JoinColumn(name="page_id")
    public List<DynamicWebContentMapping> getDynamicWebContentMappingList() {
        return dynamicWebContentMappingList;
    }

    public void setDynamicWebContentMappingList(List<DynamicWebContentMapping> dynamicWebContentMappingList) {
        this.dynamicWebContentMappingList = dynamicWebContentMappingList;
    }


    public WebPageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(WebPageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
