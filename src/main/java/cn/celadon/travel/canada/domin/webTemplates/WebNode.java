package cn.celadon.travel.canada.domin.webTemplates;

import cn.celadon.travel.canada.Util.StaticWebPageConst;
import cn.celadon.travel.canada.view.PageNavData;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by empqqty on 6/13/2017.
 */
@Entity
@Table(name = "web_node")
public class WebNode {
    private Long id;
    private WebNode parentNode;
    private String displayName;
    private PageModule webPage;
    private WebNodeType nodeType;
    private Date createTime;
    private Date updateTime;

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

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH}, optional = true, fetch = FetchType.EAGER,  targetEntity = WebNode.class)
    @JoinColumn(name = "parent_node_id", columnDefinition="integer")
    public WebNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(WebNode parentNode) {
        this.parentNode = parentNode;
    }

    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH}, optional = true, fetch = FetchType.EAGER,  targetEntity = PageModule.class)
    @JoinColumn(name = "page_id", columnDefinition="integer")
    public PageModule getWebPage() {
        return webPage;
    }

    public void setWebPage(PageModule webPage) {
        this.webPage = webPage;
    }

    @Column( name = "node_type")
    public WebNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(WebNodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Column( name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column ( name = "update_time" )
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public PageNavData generateNavData(){
        PageNavData navData = new PageNavData();
        navData.setItem_id(this.id.intValue());
        navData.setItem_name(this.displayName);
        if (this.getNodeType() != null){
            navData.setItem_type(this.getNodeType().name());
        }

        if (this.getParentNode() == null){
            navData.setParent_item(0);
        } else {
            navData.setParent_item(this.getParentNode().getId().intValue());
        }

        if (this.getWebPage() == null){

        } else {
            navData.setUrl(this.getWebPage().getPageInfo().getPageHtmlName()+ StaticWebPageConst.HTML_SUFFIX);
        }

        return navData;
    }
}
