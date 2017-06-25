package cn.celadon.travel.canada.domin;

/**
 * Created by empqqty on 6/1/2017.
 */
public enum ArticleTemplate {
    No_IMAGE(0), FULL_SIZE_IMAGE(1),LEFT_CIRCLE_IMAGE(2);
    private int id;
    ArticleTemplate(int id) {
        this.id = id;
    }

}
