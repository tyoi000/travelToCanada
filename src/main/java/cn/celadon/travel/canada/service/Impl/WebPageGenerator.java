package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.Util.StaticWebPageConst;
import cn.celadon.travel.canada.annotations.DynamicWebEntity;
import cn.celadon.travel.canada.domin.EntityBaseHtml;
import cn.celadon.travel.canada.domin.IWebModuleRegister;
import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContent;
import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContentMapping;
import cn.celadon.travel.canada.domin.webTemplates.PageModule;
import cn.celadon.travel.canada.domin.webTemplates.VisitPathTracker;
import cn.celadon.travel.canada.service.IPageModuleService;
import cn.celadon.travel.canada.service.IStaticPageGenerator;
import cn.celadon.travel.canada.service.IWebNodeService;
import cn.celadon.travel.canada.service.IWebPageGenerator;
import cn.celadon.travel.canada.view.PageNavData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;

/**
 * Created by empqqty on 7/6/2017.
 */
@Service
public class WebPageGenerator implements IWebPageGenerator {

    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(WebPageGenerator.class);

    private static String annotationClassName = "DynamicWebEntity";
    @Autowired
    private IPageModuleService pageModuleService;

    @Autowired
    private IStaticPageGenerator staticPageGenerator;

    @Autowired
    private IWebNodeService webNodeService;

    public WebPageGenerator() {
    }

    @Value("${static.page.output.path}")
    private String storagePath = "/";

    @Value("${web_logo_title}")
    private String logo_str = "";

    @Value("${web_logo_image}")
    private String logo_img = "";

    @Override
    public void generateAllAvailableWebPages() {

        try {
            storagePath = ResourceUtils.getURL(storagePath).getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> webDynamicModule = IWebModuleRegister.webModules;
        List<PageModule> pageModules = pageModuleService.findAllPages();
        for (PageModule pageModule : pageModules){
            generateStaticHtmlForSinglePage(webDynamicModule, pageModule);
        }

        generateHeaderContent();
    }

    public void generateHeaderContent(){
        try {
            Map<String, Object> headerData = new HashMap<>();
            List<PageNavData> pageNavDatas = new ArrayList<>();
            transferWebNodeToPageNav(pageNavDatas);
            headerData.put("nav", pageNavDatas);
            headerData.put("logo", logo_str);
            headerData.put("logo_image",logo_img);
            Gson gsonJsonParser = new GsonBuilder().create();
            String jsonData = gsonJsonParser.toJson(headerData);
            Map<String, Object> headerDataMapping = new HashMap<>();
            headerDataMapping.put("headerData",jsonData);
            String jsFilePath = storagePath + StaticWebPageConst.HTML_PATH_SEPARATOR +
                    StaticWebPageConst.JS_FOLDER + StaticWebPageConst.HTML_PATH_SEPARATOR +
                    StaticWebPageConst.ACTIVE_JS_FOLDER + StaticWebPageConst.HTML_PATH_SEPARATOR +
                    "header" + StaticWebPageConst.JS_SUFFIX;
            staticPageGenerator.generateSinglePage("jsTemplate/header.ftl",headerDataMapping,jsFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void transferWebNodeToPageNav(List<PageNavData> pageNavDatas){
        List<WebNode> webNodeList = webNodeService.findAllWebNodes();
        for (WebNode webNode : webNodeList) {
            pageNavDatas.add(webNode.generateNavData());
        }
    }

    private void generateStaticHtmlForSinglePage(Map<String, Object> webDynamicModule, PageModule currentPage) {
        try {
            Map<String, Object> htmlContent = new HashMap<>();
            addInnerAreas(webDynamicModule, currentPage, htmlContent);
            String currentPageHtml = storagePath + StaticWebPageConst.HTML_PATH_SEPARATOR + currentPage.getPageInfo().getPageHtmlName() + StaticWebPageConst.HTML_SUFFIX;
            if (currentPage.getStaticContentMappingName() != null){
                htmlContent.put(currentPage.getStaticContentMappingName(),currentPage.getStaticContent());
            }
            htmlContent.put(StaticWebPageConst.CURRENT_PAGE_VISIT_PATH_KEY,currentPage.getPageInfo());
            staticPageGenerator.generateSinglePage(currentPage.getPageInfo().getPageTemplate(),htmlContent,currentPageHtml);
        } catch (Exception e) {
            logger.error("Failed when create single page",e);
        }
    }

    private void addInnerAreas(Map<String, Object> webDynamicModule, PageModule currentPage, Map<String, Object> htmlContent) {
        if (currentPage.getDynamicWebContentMappingList() != null && currentPage.getDynamicWebContentMappingList().size() >0){

            for (DynamicWebContentMapping innerArea : currentPage.getDynamicWebContentMappingList()){
                //todo generate Summary page && generate page for every entity
                Object entityService = webDynamicModule.get(innerArea.getDynamicWebContent().getDynamicEntityMapping());
                Method[] methods = entityService.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(DynamicWebEntity.class)){
                        try {

                            Object result = null;
                            List<Object> innerAreaEntity = null;
                            if (innerArea.getDynamicWebContent().getDynamicEntityMapping().equals("otherStaticInfo")){
                                result = method.invoke(entityService,innerArea.getDynamicWebContent().getEntityFilterType());
                                innerAreaEntity = (List<Object>) result;
                            } else {
                                result = method.invoke(entityService);
                                List<VisitPathTracker> visitPathTrackers = new ArrayList<>();
                                if (currentPage.getVisitPath() == null){
                                    //do nothing
                                } else {
                                    visitPathTrackers.addAll(currentPage.getVisitPath());
                                }

                                VisitPathTracker currentPagePath = new VisitPathTracker();
                                currentPagePath.setHtml(currentPage.getPageInfo().getPageHtmlName()+ StaticWebPageConst.HTML_SUFFIX);
                                currentPagePath.setDisplayName(currentPage.getName());
                                visitPathTrackers.add(currentPagePath);


                                List<Object> entityList = (List<Object>) result;
                                if (entityList.size() > innerArea.getInnerAreaMappingRecordNumber()){
                                    innerAreaEntity = entityList.subList(0,innerArea.getInnerAreaMappingRecordNumber());
                                } else {
                                    innerAreaEntity = entityList;
                                }


                                VisitPathTracker entitySummaryPagePath = generateDynamicEntity(innerArea,visitPathTrackers,entityList);
                                htmlContent.put(innerArea.getInnerAreaMappingName() + StaticWebPageConst.MORE_DETAIL_LINK_SUFFIX, entitySummaryPagePath);
                            }

                            htmlContent.put(innerArea.getInnerAreaMappingName(),innerAreaEntity);

                        } catch (Exception e) {
                            logger.error("Static page generation failed",e);
                        }

                        break;
                    } else {
                        continue;
                    }

                }

            }
        }
    }

    @Override
    public void updateWebPages() {

    }

    @Override
    public void clearAll() {

    }


    private VisitPathTracker generateDynamicEntity(DynamicWebContentMapping dynamicWebContentMapping, List<VisitPathTracker> visitPathTrackers, List<Object> entityList) throws Exception{

        VisitPathTracker currentPageVisitPath = new VisitPathTracker();
        currentPageVisitPath.setHtml(dynamicWebContentMapping.getDynamicWebContent().getSummaryPage().getPageHtmlName() + StaticWebPageConst.HTML_SUFFIX);
        currentPageVisitPath.setDisplayName(dynamicWebContentMapping.getDynamicWebContent().getSummaryPage().getPageDisplayName());

        generateEntityStaticHtmlPage(dynamicWebContentMapping.getDynamicWebContent(), visitPathTrackers, entityList, currentPageVisitPath);

        Map<String, Object> summaryHtmlContent = new HashMap<String, Object>();
        // the summary html name will also be used in template mapping for summary page
        summaryHtmlContent.put("pageTotal", Math.ceil((double) entityList.size()/10));
        summaryHtmlContent.put("item_summary", entityList);
        summaryHtmlContent.put(StaticWebPageConst.PARENT_NODE_VISIT_PATH_KEY, visitPathTrackers);
        summaryHtmlContent.put(StaticWebPageConst.CURRENT_PAGE_VISIT_PATH_KEY, currentPageVisitPath);
        try {
            String filePath = storagePath +StaticWebPageConst.HTML_PATH_SEPARATOR+ currentPageVisitPath.getHtml();
            staticPageGenerator.generateSinglePage(dynamicWebContentMapping.getDynamicWebContent().getSummaryPage().getPageTemplate(),summaryHtmlContent,filePath);
        } catch (Exception e) {
            logger.error("Summary page generation failed !",e);
            throw e;
        }

        return currentPageVisitPath;
    }

    private void generateEntityStaticHtmlPage(DynamicWebContent dynamicWebContent, List<VisitPathTracker> visitPathTrackers, List<Object> entityList, VisitPathTracker currentPageVisitPath) throws Exception {
        logger.info("Entity html generation begins : " + dynamicWebContent.getDynamicEntityMapping());
        List<VisitPathTracker> entityVisitPaths = new ArrayList<>();
        entityVisitPaths.addAll(visitPathTrackers);
        entityVisitPaths.add(currentPageVisitPath);

        // for every entity, the module mapping key will also be the name mapping in template
        String entityMappingNameInTemplate = dynamicWebContent.getDynamicEntityMapping();
        int recordIndex=1;
        int pageCapacity=10;
        for (Object entity : entityList){

            EntityBaseHtml htmlEntity = (EntityBaseHtml) entity;

            String entityId = String.valueOf(entity.getClass().getDeclaredMethod("getId").invoke(entity));
            String[] htmlNameArray = new String[1];
            htmlNameArray[0] = entityId;
            htmlEntity.setHtmlLink(getHtmlPageNameForEntity(dynamicWebContent.getEntityPage().getPageHtmlName(),htmlNameArray));

            double pageNumber=Math.ceil((double) recordIndex/pageCapacity);
            htmlEntity.setPageNumber((int)pageNumber);

            Map<String, Object> entityHtmlContent = new HashMap<>();
            entityHtmlContent.put(entityMappingNameInTemplate, entity);
            entityHtmlContent.put(StaticWebPageConst.PARENT_NODE_VISIT_PATH_KEY, entityVisitPaths);
            String entityFilePath = storagePath +StaticWebPageConst.HTML_PATH_SEPARATOR + htmlEntity.getHtmlLink();
            staticPageGenerator.generateSinglePage(dynamicWebContent.getEntityPage().getPageTemplate(),entityHtmlContent,entityFilePath);
            recordIndex ++;
        }
        logger.info("Entity html generation ends : " + dynamicWebContent.getDynamicEntityMapping());

    }

    private String getHtmlPageNameForEntity(String namingPattern, String[] parameters){
        String htmlName = MessageFormat.format(namingPattern,parameters) + StaticWebPageConst.HTML_SUFFIX;
        return htmlName;
    }
}
