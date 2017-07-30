package cn.celadon.travel.canada.domin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by empqqty on 7/6/2017.
 */
public interface IWebModuleRegister {
    public static Map<String,Object> webModules = new HashMap<>();
    public void register();

}
