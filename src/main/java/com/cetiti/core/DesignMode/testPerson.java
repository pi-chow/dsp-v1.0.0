package com.cetiti.core.DesignMode;

import com.cetiti.core.DesignMode.Observer.Impl.CurrentConditionDisplay;
import com.cetiti.core.DesignMode.Observer.Impl.CurrentConditionDisplay2;
import com.cetiti.core.DesignMode.Observer.Impl.PersonData;
import com.cetiti.core.DesignMode.Observer.Impl.PersonData2;

public class testPerson {
    public static void main(String[] args){
        PersonData personData = new PersonData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(personData);
        personData.setMeasurements("GreekAlphabet16th","male",27);
        PersonData2 personData2 = new PersonData2();
        CurrentConditionDisplay2 currentConditionDisplay2 = new CurrentConditionDisplay2(personData2);
        personData.setMeasurements("GreekAlphabet16th","male",28);
    }
}
