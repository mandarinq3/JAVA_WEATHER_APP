package com.example.theweatherforecast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeekFragmentViewModel extends ViewModel {


//names
    static MutableLiveData<String> dayNameOne = new MutableLiveData<>();
    static MutableLiveData<String> dayNameTwo = new MutableLiveData<>();
    static MutableLiveData<String> dayNameThree = new MutableLiveData<>();
    static MutableLiveData<String> dayNameFour = new MutableLiveData<>();
    static MutableLiveData<String> dayNameFive = new MutableLiveData<>();
    static MutableLiveData<String> dayNameSix = new MutableLiveData<>();

    // temperatures
    static MutableLiveData<String> dayTempOne = new MutableLiveData<>();
    static MutableLiveData<String> dayTempTwo = new MutableLiveData<>();
    static MutableLiveData<String> dayTempThree = new MutableLiveData<>();
    static MutableLiveData<String> dayTempFour = new MutableLiveData<>();
    static MutableLiveData<String> dayTempFive = new MutableLiveData<>();
    static MutableLiveData<String> dayTempSix = new MutableLiveData<>();

    public WeekFragmentViewModel() {
        //setting day names
        dayNameOne.setValue("monday");
        dayNameTwo.setValue("tuesday");
        dayNameThree.setValue("wednesday");
        dayNameFour.setValue("thursday");
        dayNameFive.setValue("friday");
        dayNameSix.setValue("saturday");
        
        //setting day temperatures
        dayTempOne.setValue("monday");
        dayTempTwo.setValue("tuesday");
        dayTempThree.setValue("wednesday");
        dayTempFour.setValue("thursday");
        dayTempFive.setValue("friday");
        dayTempSix.setValue("saturday");
    }

}
