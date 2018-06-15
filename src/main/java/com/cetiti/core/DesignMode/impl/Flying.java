package com.cetiti.core.DesignMode.impl;

import com.cetiti.core.DesignMode.FlyBehavior;

public class Flying implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("=========flying");
    }
}
