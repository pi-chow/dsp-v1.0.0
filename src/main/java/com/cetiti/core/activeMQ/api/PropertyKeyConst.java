package com.cetiti.core.activeMQ.api;



/**
 *描述：consumer参数配置key
 * @author zhouliyu
 * */
public class PropertyKeyConst {
    //控制台创建的ConsumerId
    public static final String ConsumerId ;
    //控制台创建的身份验证
    public static final String AppKey;
    public static final String AppSecret;
    //订阅方式
    public static final String MessageModel;

    static {
        ConsumerId = "ConsumerId";
        AppKey = "AppKey";
        AppSecret = "AppSecret";
        MessageModel = "MessageModel";
    }
}
