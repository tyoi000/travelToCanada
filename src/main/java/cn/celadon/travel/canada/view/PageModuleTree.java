package cn.celadon.travel.canada.view;

import cn.celadon.travel.canada.domin.webTemplates.PageModule;

import java.util.List;

/**
 * Created by empqqty on 7/7/2017.
 */
public class PageModuleTree {
    private PageModule currentPageMoodule;
    private List<PageModuleTree> childPages;

    public PageModule getCurrentPageMoodule() {
        return currentPageMoodule;
    }

    public void setCurrentPageMoodule(PageModule currentPageMoodule) {
        this.currentPageMoodule = currentPageMoodule;
    }

    public List<PageModuleTree> getChildPages() {
        return childPages;
    }

    public void setChildPages(List<PageModuleTree> childPages) {
        this.childPages = childPages;
    }
}
