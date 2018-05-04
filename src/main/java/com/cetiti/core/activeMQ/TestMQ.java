package com.cetiti.core.activeMQ;

import com.cetiti.dsp.entity.Goods;

public class TestMQ {
    public static void main(String[] args){
        DspPublisher dspPublisher = new DspPublisher();
        //货物实例
        Goods goods1 = new Goods();
        goods1.setGoodsId(1000l);
        goods1.setTitle("ipad");
        goods1.setPrice(1999);
        Goods goods2 = new Goods();
        goods2.setGoodsId(1001l);
        goods2.setTitle("iphoneX");
        goods2.setPrice(6999);

        dspPublisher.init();
        TestMQ testMQ = new TestMQ();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(testMQ.new publishMq(dspPublisher,10001l,goods1)).start();
        new Thread(testMQ.new publishMq(dspPublisher,10002l,goods2)).start();
    }

    private class publishMq implements Runnable{
        DspPublisher dspPublisher;
        Goods goods;
        Long consumerId;
        public  publishMq(DspPublisher dspPublisher,Long consumerId, Goods goods){
            this.dspPublisher = dspPublisher;
            this.goods = goods;
            this.consumerId = consumerId;
        }
        @Override
        public void run() {
            while (true){
                try {
                    dspPublisher.sendMessage("apiInfo",consumerId,goods);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
