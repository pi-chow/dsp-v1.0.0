package com.cetiti.core.DesignMode;

import com.cetiti.core.DesignMode.FlyBehavior;

public class Duck {
    FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }
}
