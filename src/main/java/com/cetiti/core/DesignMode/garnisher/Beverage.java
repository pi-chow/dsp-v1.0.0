package com.cetiti.core.DesignMode.garnisher;

public abstract class Beverage {
    String description = "Unknow";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
