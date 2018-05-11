package com.cetiti.core.activeMQ.service;

import com.cetiti.dsp.entity.Producer;

import java.util.List;

/**
 * /**
 * 描述：MQ消息发送者管理
 * @author zhouliyu
 * */
public interface ProducerManage {

    int insertProducerInfo(Producer Producer);
    int updateProducerInfo(Producer Producer);
    int deleteProducerInfo(Producer Producer);
    List<Producer> getProducerInfos(String keyWord);

    /**
     * 发送消息
     * 消息功能：1.定时消息2.广播消息3.消息堆积[持久化]4.消息过滤
     *
     * */
    <T> String sendCommonMessage(Producer producer,String messageKey,List<T> objList);
}
