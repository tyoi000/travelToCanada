package cn.celadon.travel.canada.annotations;

import java.lang.annotation.*;

/**
 * Created by empqqty on 6/30/2017.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InnerContent {
    public String displayInPage() default "";
    public String htmlLink() default "";
}
