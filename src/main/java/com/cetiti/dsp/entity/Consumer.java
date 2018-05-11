package com.cetiti.dsp.entity;

import java.util.Date;

public class Consumer {

    private Long consumerId;
    private String consumerName;
    private String topicName;
    private Date CreateTime;

    public Consumer() {
        super();
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "DspMqConsumer{" +
                "consumerId=" + consumerId +
                ", consumerName='" + consumerName + '\'' +
                ", topicName='" + topicName + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
