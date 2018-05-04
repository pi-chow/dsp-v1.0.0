package com.cetiti.core.activeMQ;

public class TestConsumer {
    public static void main(String[] args){
        DspConsumer dspConsumer = new DspConsumer();
        dspConsumer.init();
        TestConsumer testConsumer = new TestConsumer();
        Long[] admin = {10001l,10002l};
        Long[] demo = {10001l};
        new Thread(testConsumer.new ConsumerMq(dspConsumer,"apiInfo",admin,"admin")).start();
        new Thread(testConsumer.new ConsumerMq(dspConsumer,"apiInfo",demo,"demo")).start();
    }

    private class ConsumerMq implements Runnable{
        DspConsumer dspConsumer;
        String topic;
        Long[] consumerIds;
        String user;
        public ConsumerMq(DspConsumer dspConsumer,String topic, Long[] consumerIds, String user){
            this.dspConsumer = dspConsumer;
            this.user = user;
            this.topic = topic;
            this.consumerIds = consumerIds;
        }

        @Override
        public void run() {
            dspConsumer.getMessage(topic,consumerIds,user);

        }
    }
}
