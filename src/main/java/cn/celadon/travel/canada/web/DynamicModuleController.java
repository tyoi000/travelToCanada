package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContent;
import cn.celadon.travel.canada.service.IDynamicModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 7/23/2017.
 */
@RestController
@RequestMapping( value = "/dynamicModule")
public class DynamicModuleController {

    @Autowired
    private IDynamicModuleService dynamicModuleService;

    @RequestMapping( value = "/")
    @ResponseBody
    public List<DynamicWebContent> findAll(){
        return dynamicModuleService.findAll();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public void add(@RequestBody DynamicWebContent dynamicWebContent){
        dynamicModuleService.add(dynamicWebContent);
    }

    @RequestMapping(value="/update", method= RequestMethod.POST)
    public void update(@RequestBody DynamicWebContent dynamicWebContent){
        dynamicModuleService.update(dynamicWebContent);
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public void deletePageModule(@RequestParam(value = "id") String id){
        dynamicModuleService.deleteById(Long.parseLong(id));
    }
}
