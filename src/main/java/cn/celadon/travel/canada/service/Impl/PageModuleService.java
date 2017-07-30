package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.webTemplates.PageModule;
import cn.celadon.travel.canada.repository.PageModuleRepository;
import cn.celadon.travel.canada.service.IPageModuleService;
import cn.celadon.travel.canada.view.PageModuleTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by empqqty on 7/6/2017.
 */
@Service
@Transactional
public class PageModuleService implements IPageModuleService {

    @Autowired
    private PageModuleRepository pageModuleRepository;

    @Override
    public List<PageModule> findAllPages() {
        return pageModuleRepository.findAll();
    }

    @Override
    public PageModule findPageWithId(Long pageId) {
        return pageModuleRepository.findById(pageId).get();
    }

    @Override
    public void addPageModule(PageModule pageModule) {
        pageModuleRepository.save(pageModule);
    }

    @Override
    public void deletePageModule(Long pageId) {
         pageModuleRepository.deleteById(pageId);
    }


    @Override
    @Modifying
    public void updatePageModule(PageModule pageModule) {
        PageModule pageModuleInDB = pageModuleRepository.findById(pageModule.getId()).get();
        if (pageModuleInDB == null) {
            //// TODO: 7/17/2017 throws exceptions to remind this
        } else {
            pageModuleRepository.saveAndFlush(pageModule);
        }
    }
}
