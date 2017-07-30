package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.domin.dynamicDataModules.OtherStaticData;
import cn.celadon.travel.canada.service.IOtherStaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
@RestController
@RequestMapping( value = "/staticData")
public class OtherStaticDataController {

    @Autowired
    private IOtherStaticDataService otherStaticDataService;

    @RequestMapping(value="/")
    @ResponseBody
    public List<OtherStaticData> getAll(){

        List<OtherStaticData> OtherStaticDataList = otherStaticDataService.findAll();
        return OtherStaticDataList;
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Object add(@RequestBody OtherStaticData otherStaticData)
    {
        otherStaticDataService.addNewStaticData(otherStaticData);
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add other static info succeed");
        return resultMsg;
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public Object delete(@RequestParam(value = "id") String id){
        otherStaticDataService.deleteById(Long.parseLong(id));
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Delete other static info succeed");
        return resultMsg;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Object update(@RequestBody OtherStaticData otherStaticData)
    {   ResultMsg resultMsg = null;
        otherStaticDataService.updateStaticData(otherStaticData);
        resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add other static info succeed");
        return resultMsg;
    }
}
