package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.annotations.DynamicWebEntity;
import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.OtherStaticData;
import cn.celadon.travel.canada.repository.OtherStaticDataRepository;
import cn.celadon.travel.canada.service.IOtherStaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
@Service
@Transactional
public class OtherStaticDataServiceImpl implements IOtherStaticDataService{

    @Autowired
    private OtherStaticDataRepository otherStaticDataRepository;

    @Override
    public void register() {
        IWebModuleRegister.webModules.put("otherStaticInfo", this);
    }

    @Override
    public List<OtherStaticData> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "type");
        return otherStaticDataRepository.findAll();
    }

    @Override
    @DynamicWebEntity
    public List<OtherStaticData> findByType(String type) {
        return otherStaticDataRepository.findByDataType(type);
    }

    @Override
    public void addNewStaticData(OtherStaticData otherStaticData) {
        otherStaticDataRepository.save(otherStaticData);
    }

    @Override
    public void updateStaticData(OtherStaticData otherStaticData) {

        otherStaticDataRepository.saveAndFlush(otherStaticData);
    }

    @Override
    public void deleteById(Long id) {

        otherStaticDataRepository.deleteById(id);
    }
}
