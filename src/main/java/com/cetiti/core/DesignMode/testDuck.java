package com.cetiti.core.DesignMode;

import com.cetiti.core.DesignMode.impl.Flying;
import com.cetiti.core.DesignMode.impl.NoFlying;

public class testDuck extends Duck {

    public testDuck(){
        flyBehavior = new NoFlying();
    }

    public static void main(String[] args){
        testDuck testDuck = new testDuck();
        testDuck.setFlyBehavior(new Flying());
        testDuck.performFly();
    }
}
