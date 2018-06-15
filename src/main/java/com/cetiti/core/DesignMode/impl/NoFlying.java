package com.cetiti.core.DesignMode.impl;

import com.cetiti.core.DesignMode.FlyBehavior;

public class NoFlying implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("=========no flying");
    }
}
