package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.domin.dynamicDataModules.SchoolInformation;
import cn.celadon.travel.canada.service.ISchoolInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
@RestController
@RequestMapping( value = "/schoolInfo")
public class SchoolInformationController {
    @Autowired
    private ISchoolInformationService schoolInformationService;

    @RequestMapping(value="/")
    @ResponseBody
    public List<SchoolInformation> getAll(){

        List<SchoolInformation> schoolInformation = schoolInformationService.findAll();
        return schoolInformation;
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Object add(@RequestBody SchoolInformation schoolInformation)
    {
        schoolInformationService.addSchoolInformation(schoolInformation);
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add school information succeed");
        return resultMsg;
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public Object delete(@RequestParam(value = "id") String id){
        schoolInformationService.deleteSchoolInformation(Long.parseLong(id));
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Delete school information succeed");
        return resultMsg;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Object update(@RequestBody SchoolInformation schoolInformation)
    {   ResultMsg resultMsg = null;
        schoolInformationService.updateSchoolInformation(schoolInformation);
        resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add school information succeed");
        return resultMsg;
    }
}
