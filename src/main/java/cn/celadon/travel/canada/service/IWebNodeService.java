package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.view.WebNodeTree;

import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */
public interface IWebNodeService {

    public List<WebNode> findAllWebNodes();
    public void addWebNode(WebNode newWebNode);
    public void updateWebNode(WebNode updatedWebNode);
    public void batchUpdateWebNodes(List<WebNode> webNodes);
    public void deleteWebNode(Long webNodeId);
    public void deleteAllWebNodes();
    public WebNodeTree getTreeStructure();

}
