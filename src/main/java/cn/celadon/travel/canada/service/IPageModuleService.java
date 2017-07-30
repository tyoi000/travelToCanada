package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.webTemplates.PageModule;
import cn.celadon.travel.canada.view.PageModuleTree;

import java.util.List;

/**
 * Created by empqqty on 7/6/2017.
 */
public interface IPageModuleService {

    public List<PageModule> findAllPages();
    public PageModule findPageWithId(Long pageId);
    public void addPageModule(PageModule pageModule);
    public void deletePageModule(Long pageId);
    public void updatePageModule(PageModule pageModule);
}
