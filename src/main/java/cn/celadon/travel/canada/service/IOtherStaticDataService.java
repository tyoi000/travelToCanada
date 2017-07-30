package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.OtherStaticData;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
public interface IOtherStaticDataService extends IWebModuleRegister{
    public List<OtherStaticData> findAll();

    @Query("from OtherStaticData o where o.dataType=:type ")
    public List<OtherStaticData> findByType(String type);

    public void addNewStaticData(OtherStaticData otherStaticData);

    public void updateStaticData(OtherStaticData otherStaticData);

    public void deleteById(Long id);

}
