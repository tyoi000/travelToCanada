package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.annotations.DynamicWebEntity;
import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.SchoolInformation;
import cn.celadon.travel.canada.repository.SchoolInformationRepository;
import cn.celadon.travel.canada.service.ISchoolInformationService;
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
public class SchoolInformationServiceImpl implements ISchoolInformationService {

    @Autowired
    private SchoolInformationRepository schoolInformationRepository;

    @Override
    @DynamicWebEntity
    public List<SchoolInformation> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC,"ranking");
        return schoolInformationRepository.findAll(sort);
    }

    @Override
    public SchoolInformation findById(Long id) {
        return schoolInformationRepository.findById(id).get();
    }

    @Override
    public void addSchoolInformation(SchoolInformation schoolInformation) {
        schoolInformation.setPublishTime(new Date());
         schoolInformationRepository.save(schoolInformation);
    }

    @Override
    public void updateSchoolInformation(SchoolInformation schoolInformation) {
         schoolInformationRepository.saveAndFlush(schoolInformation);
    }

    @Override
    public void deleteSchoolInformation(Long id) {
         schoolInformationRepository.deleteById(id);
    }

    @Override
    @PostConstruct
    public void register() {
        IWebModuleRegister.webModules.put("schoolInfo",this);

    }
}
