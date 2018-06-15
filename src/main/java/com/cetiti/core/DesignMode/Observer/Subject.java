package com.cetiti.core.DesignMode.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
