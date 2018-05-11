package com.cetiti.dsp.entity;

import java.util.Date;

public class Topic {
    private String topicName;
    private String messageType;
    private int serverStatus;
    private String authorization;
    private Date createTime;
    private String description;

    public Topic() {
        super();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(int serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                ", messageType='" + messageType + '\'' +
                ", serverStatus=" + serverStatus +
                ", authorization='" + authorization + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                '}';
    }
}
