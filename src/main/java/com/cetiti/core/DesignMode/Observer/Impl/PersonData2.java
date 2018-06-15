package com.cetiti.core.DesignMode.Observer.Impl;

import java.util.Observable;

public class PersonData2 extends Observable {
    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    /**
     * 通知
     */
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;

    }
}
