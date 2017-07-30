package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.domin.webTemplates.PageModule;
import cn.celadon.travel.canada.service.IPageModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 7/17/2017.
 */
@RestController
@RequestMapping( value = "/pageModules")
public class PageModuleController {
    @Autowired
    private IPageModuleService pageModuleService;

    @RequestMapping( value = "/")
    @ResponseBody
    public List<PageModule> findAllPageModules(){
        return pageModuleService.findAllPages();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public void addNewPageModule(@RequestBody PageModule pageModule){
        pageModuleService.addPageModule(pageModule);
    }

    @RequestMapping(value="/update", method= RequestMethod.POST)
    public void updatePageModule(@RequestBody PageModule pageModule){
        pageModuleService.updatePageModule(pageModule);
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public void deletePageModule(@RequestParam(value = "id") String pageModuleId){
        pageModuleService.deletePageModule(Long.parseLong(pageModuleId));
    }
}
