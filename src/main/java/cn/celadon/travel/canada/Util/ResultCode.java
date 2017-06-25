package cn.celadon.travel.canada.Util;

/**
 * Created by empqqty on 6/1/2017.
 */
public enum ResultCode {
    SUCCESS(200),ERROR(-1);
    private int code;

    ResultCode(int code) {
        this.code = code;
    }
}
