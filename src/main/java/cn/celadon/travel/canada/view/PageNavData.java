package cn.celadon.travel.canada.view;

/**
 * Created by empqqty on 7/16/2017.
 */
public class PageNavData {
    private int item_id;
    private String item_name;
    private String url;
    private String item_type;
    private int parent_item;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getParent_item() {
        return parent_item;
    }

    public void setParent_item(int parent_item) {
        this.parent_item = parent_item;
    }
}
