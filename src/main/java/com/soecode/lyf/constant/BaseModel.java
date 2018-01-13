package com.soecode.lyf.constant;

public class BaseModel {
    private int code;
    private Object msg;
    private Object data;

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseModel(int code, Object data) {
        if(code==200){
            this.code = code;
            this.data = data;
        }else{
            this.code = code;
            this.msg = data;
        }
    }
}
