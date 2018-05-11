package com.cetiti.dsp.service.impl;

import com.cetiti.core.activeMQ.service.ConsumerManage;
import com.cetiti.dsp.entity.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ConsumerManage")
public class ConsumerManageImpl implements ConsumerManage {



    @Override
    public int insertConsumerInfo(Consumer consumer) {
        return 0;
    }

    @Override
    public int updateConsumerInfo(Consumer consumer) {
        return 0;
    }

    @Override
    public int deleteConsumerInfo(Consumer consumer) {
        return 0;
    }

    @Override
    public List<Consumer> getConsumerInfos(String keyWord) {
        return null;
    }

    @Override
    public <T> List<T> onCommonMessage(Consumer consumer, String messageKey, Class<T> targetClass) {



        return null;
    }

}
