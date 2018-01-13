package com.soecode.lyf.constant;

public enum FinalVal {
    SUCCESS("200", "成功"),
    NOT_LOGIN("400", "没有登录"),
    EXCEPTION("401", "发生异常"),
    SYS_ERROR("402", "系统错误"),
    PARAMS_ERROR("403", "参数错误 "),
    NOT_SUPPORTED("410", "不支持或已经废弃"),
    INVALID_AUTHCODE("444", "无效的AuthCode"),
    TOO_FREQUENT("445", "太频繁的调用"),
    UNKNOWN_ERROR("499", "未知错误"),
    USER_DEFINED("000", "自定义");

    private String val;
    private String msg;

    private FinalVal(String val,String msg){

    }

    private String val(){
        return this.val;
    }

    private String msg(){
        return this.msg();
    }
}
