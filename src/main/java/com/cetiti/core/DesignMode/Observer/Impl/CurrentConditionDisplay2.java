package com.cetiti.core.DesignMode.Observer.Impl;

import com.cetiti.core.DesignMode.Observer.DisplayElement;

import java.util.Observable;

public class CurrentConditionDisplay2 implements java.util.Observer, DisplayElement {
    private String name;
    private String sex;
    private int age;
    Observable observable;

    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Person: " + " name: " + name+ " sex: " + sex+ " age: " + age);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PersonData2){
            PersonData2 personData = (PersonData2)o;
            this.name = personData.getName();
            this.sex = personData.getSex();
            this.age = personData.getAge();
            display();
        }
    }
}
