package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContent;
import cn.celadon.travel.canada.repository.DynamicWebContentRepository;
import cn.celadon.travel.canada.service.IDynamicModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by empqqty on 7/23/2017.
 */
@Service
@Transactional
@Component
public class DynamicModuleServiceImpl implements IDynamicModuleService {

    @Autowired
    private DynamicWebContentRepository dynamicWebContentRepository;

    @Override
    public List<DynamicWebContent> findAll() {
        return dynamicWebContentRepository.findAll();
    }

    @Override
    public void add(DynamicWebContent dynamicWebContent) {
        dynamicWebContentRepository.save(dynamicWebContent);
    }

    @Override
    public void deleteById(Long id) {
        dynamicWebContentRepository.deleteById(id);
    }

    @Override
    public void update(DynamicWebContent dynamicWebContent) {
         dynamicWebContentRepository.saveAndFlush(dynamicWebContent);
    }

    @Override
    public DynamicWebContent findById(Long id) {
        return dynamicWebContentRepository.findById(id).get();
    }
}
