package cn.celadon.travel.canada.domin.dynamicDataModules;

import cn.celadon.travel.canada.domin.EntityBaseHtml;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by empqqty on 7/22/2017.
 */
@Entity
@Table(name = "other_static_data")
public class OtherStaticData extends EntityBaseHtml {

    private long id;
    private String dataType;
    private String dataName;
    private String content;
    private String description;
    private String htmlLink;

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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }
}
