package cn.cooode.activityTools.dto;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
public class ResultDto {

    private boolean status;
    private String msg;

    public ResultDto(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultDto(boolean status){
        this(true,"");
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
