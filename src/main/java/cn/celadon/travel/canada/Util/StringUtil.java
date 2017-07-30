package cn.celadon.travel.canada.Util;

/**
 * Created by empqqty on 7/22/2017.
 */
public  class StringUtil {

    public static String substringAfter(String parentStr, String separator){
        int index = parentStr.lastIndexOf(separator);
        if (index >= 0){
            return parentStr.substring(index+1);
        } else {
            return "";
        }
    }
}
