package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.dynamicDataModules.SchoolInformation;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
public interface ISchoolInformationService extends IWebModuleRegister {

    public List<SchoolInformation> findAll();
    public SchoolInformation findById(Long id);
    public void addSchoolInformation(SchoolInformation schoolInformation);
    public void updateSchoolInformation(SchoolInformation schoolInformation);
    public void deleteSchoolInformation(Long id);
}
