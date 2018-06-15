package com.cetiti.core.DesignMode;

import com.cetiti.core.DesignMode.garnisher.Beverage;
import com.cetiti.core.DesignMode.garnisher.Espresso;
import com.cetiti.core.DesignMode.garnisher.HouseBlend;
import com.cetiti.core.DesignMode.garnisher.Mocha;

public class testCoffee {
    public static void main(String[] args){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
    }
}
