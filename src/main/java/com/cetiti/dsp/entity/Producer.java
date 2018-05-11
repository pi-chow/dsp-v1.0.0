package com.cetiti.dsp.entity;

import java.util.Date;

public class Producer {

    private Long producerId;
    private String producerName;
    private String topicName;
    private int status;
    private Date CreateTime;


    public Producer() {
        super();
    }

    public Long getProducerId() {
        return producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }


    @Override
    public String toString() {
        return "Producer{" +
                "producerId=" + producerId +
                ", topicName='" + topicName + '\'' +
                ", status=" + status +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
