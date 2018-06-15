package com.cetiti.core.DesignMode.Observer.Impl;

import com.cetiti.core.DesignMode.Observer.Observer;
import com.cetiti.core.DesignMode.Observer.Subject;

import java.util.ArrayList;

public class PersonData implements Subject {
    private ArrayList observers;
    private String name;
    private String sex;
    private int age;

    public PersonData() {
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(name,sex,age);
        }
    }

    /**
     * 通知
     * */
    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
        measurementsChanged();
    }
}
