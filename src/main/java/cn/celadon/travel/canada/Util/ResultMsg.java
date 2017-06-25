package cn.celadon.travel.canada.Util;

/**
 * Created by empqqty on 6/1/2017.
 */
public class ResultMsg {
    private ResultCode resultCode;
    private String message;

    public ResultMsg(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
