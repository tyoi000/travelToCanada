package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.Achievement;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
public interface IAchievementService extends IWebModuleRegister {
    public List<Achievement> findAll();
    public Achievement findById(Long id);
    public void addAchievement(Achievement achievement);
    public void updateAchievement(Achievement achievement);
    public void deleteById(Long id);

}
