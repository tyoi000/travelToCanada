package cn.celadon.travel.canada.domin.webTemplates;

/**
 * Created by empqqty on 6/13/2017.
 */
public enum WebNodeType {
    NAV_NODE(0),FOOTER(1),SUBDIRECTORY(2),SINGLE_PAGE(3),COMMON_AREA(4), COMPLEX_PAGE(5), STATIC_INNER_AREA(6), DYNAMIC_INNER_AREA(7);
    private int typeId;
    WebNodeType(int typeId) {
        this.typeId = typeId;
    }
}
