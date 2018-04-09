package com.cetiti.dsp.core.model;

import java.io.Serializable;

/**
 * 描述：消息类型
 *@author zhouliyu
 * */
public class MsgModel implements Serializable{

    private static final long serialVersionUID = 1L;

    //状态值
    private String status;
    //消息
    private String msg;
    //返回对象
    private Object res;

    /**
     * 无参构造函数
     */
    public MsgModel() {
        super();
    }
    /**
     * 带参构造函数
     * @param status
     * @param msg
     * @param res
     */
    public MsgModel(String status, String msg, Object res) {
        this.status = status;
        this.msg = msg;
        this.res = res;
    }
    /**
     * 带参构造函数
     * @param status
     * @param msg
     */
    public MsgModel(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    /**
     * 带参构造函数
     * @param msg
     */
    public MsgModel(String msg) {
        super();
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getRes() {
        return res;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRes(Object res) {
        this.res = res;
    }


}
