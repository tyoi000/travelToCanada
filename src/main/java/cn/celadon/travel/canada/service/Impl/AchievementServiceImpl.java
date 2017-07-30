package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.annotations.DynamicWebEntity;
import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.Achievement;
import cn.celadon.travel.canada.repository.AchievementRepository;
import cn.celadon.travel.canada.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
@Service
@Transactional
public class AchievementServiceImpl implements IAchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    @DynamicWebEntity
    public List<Achievement> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "publishTime");
        return achievementRepository.findAll(sort);
    }

    @Override
    public Achievement findById(Long id) {
       return achievementRepository.findById(id).get();
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievement.setPublishTime(new Date());
        achievementRepository.save(achievement);
    }

    @Override
    public void updateAchievement(Achievement achievement) {
        achievementRepository.saveAndFlush(achievement);
    }

    @Override
    public void deleteById(Long id) {
       achievementRepository.deleteById(id);
    }

    @Override
    @PostConstruct
    public void register() {
        IWebModuleRegister.webModules.put("achievement",this);
    }
}
