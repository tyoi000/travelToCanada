package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.Util.exception.LogicalException;
import cn.celadon.travel.canada.domin.dynamicDataModules.Achievement;
import cn.celadon.travel.canada.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
@RestController
@RequestMapping( value = "/achievement")
public class AchievementInfoController {

    @Autowired
    private IAchievementService achievementService;

    @RequestMapping(value="/")
    @ResponseBody
    public List<Achievement> getNewsList(){

        List<Achievement> achievements = achievementService.findAll();
        return achievements;
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Object addAchievement(@RequestBody Achievement achievement)
    {
        achievementService.addAchievement(achievement);
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add achievement succeed");
        return resultMsg;
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public Object deleteAchievement(@RequestParam(value = "id") String id){
        achievementService.deleteById(Long.parseLong(id));
        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Delete achievement succeed");
        return resultMsg;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Object updateAchievement(@RequestBody Achievement achievement)
    {   ResultMsg resultMsg = null;
            achievementService.updateAchievement(achievement);
            resultMsg = new ResultMsg(ResultCode.SUCCESS, "Add achievement succeed");
        return resultMsg;
    }
}
