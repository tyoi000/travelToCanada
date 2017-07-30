package cn.celadon.travel.canada.view;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */
public class WebNodeTree {

    private WebNode currentNode;
    private List<WebNodeTree> childNode;

    public WebNodeTree() {
        childNode = new ArrayList<WebNodeTree>();
    }

    public WebNodeTree(WebNode currentNode) {
        this.currentNode = currentNode;
        childNode = new ArrayList<WebNodeTree>();
    }

    public List<WebNodeTree> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<WebNodeTree> childNode) {
        this.childNode = childNode;
    }

    public WebNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(WebNode currentNode) {
        this.currentNode = currentNode;
    }
}
