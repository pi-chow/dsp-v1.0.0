package com.cetiti.core.DesignMode.Observer.Impl;

import com.cetiti.core.DesignMode.Observer.DisplayElement;
import com.cetiti.core.DesignMode.Observer.Observer;
import com.cetiti.core.DesignMode.Observer.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private String name;
    private String sex;
    private int age;
    private Subject personData;

    public CurrentConditionDisplay(Subject personData) {
        this.personData = personData;
        personData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Person: " + " name: " + name+ " sex: " + sex+ " age: " + age);
    }

    @Override
    public void update(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        display();
    }
}
