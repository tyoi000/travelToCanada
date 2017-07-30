package cn.celadon.travel.canada.annotations;

import java.lang.annotation.*;

/**
 * Created by empqqty on 7/6/2017.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicWebEntity {
    public int recordsNum() default 5;
    public String summaryHtmlPage() default "";
    public String templateName() default "";
    public String recordNamingStrategy() default "summary_name-id";
}
