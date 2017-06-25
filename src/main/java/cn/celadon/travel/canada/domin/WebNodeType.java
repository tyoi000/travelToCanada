package cn.celadon.travel.canada.domin;

/**
 * Created by empqqty on 6/13/2017.
 */
public enum WebNodeType {
    INDEX_PAGE(0),INNER_AREA(1),SUBDIRECTORY(2),SINGLE_PAGE(3),COMMON_AREA(3);
    private int typeId;
    WebNodeType(int typeId) {
        this.typeId = typeId;
    }
}
