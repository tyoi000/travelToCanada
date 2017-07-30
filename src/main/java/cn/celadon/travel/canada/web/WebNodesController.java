package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.service.IWebNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */
@RestController
@RequestMapping( value = "/webNodes")
public class WebNodesController {

    @Autowired
    private IWebNodeService service;

    @RequestMapping( value = "/")
    @ResponseBody
    public List<WebNode> getAllValidWebNode(){
        return service.findAllWebNodes();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public void addWebNode(@RequestBody WebNode webNode){
        service.addWebNode(webNode);
    }

    @RequestMapping(value="/update", method= RequestMethod.POST)
    public void updatePageModule(@RequestBody WebNode webNode){
        service.updateWebNode(webNode);
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public void deletePageModule(@RequestParam(value = "id") String webNodeId){
        service.deleteWebNode(Long.parseLong(webNodeId));
    }

}
