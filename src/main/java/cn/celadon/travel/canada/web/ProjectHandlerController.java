package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.service.IWebPageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by empqqty on 7/23/2017.
 */
@RequestMapping("/project")
@RestController
public class ProjectHandlerController {

    @Autowired
    private IWebPageGenerator webPageGenerator;

    @RequestMapping(value="/reload")
    @ResponseBody
    public Object reloadProject(){
        webPageGenerator.generateAllAvailableWebPages();
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Project related");
        return resultMsg;
    }
}
