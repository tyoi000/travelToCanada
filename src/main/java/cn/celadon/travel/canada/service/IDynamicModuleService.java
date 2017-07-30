package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContent;

import java.util.List;

/**
 * Created by empqqty on 7/23/2017.
 */
public interface IDynamicModuleService {

    public List<DynamicWebContent> findAll();
    public void add(DynamicWebContent dynamicWebContent);
    public void deleteById(Long id);
    public void update(DynamicWebContent dynamicWebContent);
    public DynamicWebContent findById(Long id);
}
