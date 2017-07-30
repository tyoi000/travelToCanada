package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.view.WebNodeTree;
import cn.celadon.travel.canada.repository.WebNodeRepository;
import cn.celadon.travel.canada.service.IWebNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */
@Service
@Transactional
public class WebNodeServiceImpl implements IWebNodeService {

    @Autowired
    private WebNodeRepository webNodeRepository;

    @Override
    public List<WebNode> findAllWebNodes() {
        return webNodeRepository.findAll();
    }

    @Override
    public void addWebNode(WebNode newWebNode) {
         webNodeRepository.save(newWebNode);
    }

    @Override
    public void updateWebNode(WebNode updatedWebNode) {
        WebNode webNodeInDB = webNodeRepository.findById(updatedWebNode.getId()).get();
        if (webNodeInDB == null){
            //// TODO: 7/17/2017 throws exception
        } else {
            webNodeRepository.saveAndFlush(updatedWebNode);
        }
    }

    @Override
    public void batchUpdateWebNodes(List<WebNode> webNodes) {

    }

    @Override
    public void deleteWebNode(Long webNodeId) {
        WebNode targetNode = webNodeRepository.findById(webNodeId).get();
        // current only support two layers
        List<WebNode> childNodes = webNodeRepository.findChildNodes(targetNode);
        if (childNodes != null && childNodes.size()>0){
            webNodeRepository.deleteInBatch(childNodes);
        }
        webNodeRepository.deleteById(webNodeId);
    }

    @Override
    public void deleteAllWebNodes() {

        webNodeRepository.deleteAll();
    }

    @Override
    public WebNodeTree getTreeStructure() {
        List<WebNode> rawData = webNodeRepository.findAll();
        WebNodeTree root = findTopLevelNode(rawData);
        return root;
    }

    private WebNodeTree findTopLevelNode(final List<WebNode> rawData){
        WebNodeTree webRoot = new WebNodeTree();
        for ( WebNode webNode : rawData){
            if (webNode.getParentNode() == null){
                WebNodeTree webNodeTreeFirstLevel = new WebNodeTree(webNode);
                webRoot.getChildNode().add(webNodeTreeFirstLevel);
                findChildNode(rawData, webNodeTreeFirstLevel);
            }
        }

        return webRoot;
    }

    private void findChildNode(final List<WebNode> rawData, WebNodeTree currentNodeTree){
        for (WebNode singleNode : rawData){
            WebNode parentWebNode = currentNodeTree.getCurrentNode();
            if (singleNode.getParentNode() != null && singleNode.getParentNode().equals(parentWebNode)){
                WebNodeTree childWebNodeTree = new WebNodeTree(singleNode);
                currentNodeTree.getChildNode().add(childWebNodeTree);
                findChildNode(rawData, childWebNodeTree);
            }
        }
    }
}
