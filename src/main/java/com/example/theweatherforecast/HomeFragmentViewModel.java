package com.example.theweatherforecast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeFragmentViewModel extends ViewModel {

    static MutableLiveData<Integer> currentTemp = new MutableLiveData<>();
    static MutableLiveData<Double> currentCityName = new MutableLiveData<>();
    static MutableLiveData<Integer> currentFeelsLikeTemp = new MutableLiveData<>();
    static MutableLiveData<Double> currentWindSpeed = new MutableLiveData<>();
    static MutableLiveData<String> currentSunriseTime = new MutableLiveData<>();
    static MutableLiveData<String> currentSunsetTime = new MutableLiveData<>();

    //hour times
    static MutableLiveData<String> hourTimeOne = new MutableLiveData<>();
    static MutableLiveData<String> hourTimeTwo = new MutableLiveData<>();
    static MutableLiveData<String> hourTimeThree = new MutableLiveData<>();
    static MutableLiveData<String> hourTimeFour = new MutableLiveData<>();
    static MutableLiveData<String> hourTimeFive = new MutableLiveData<>();
    static MutableLiveData<String> hourTimeSix = new MutableLiveData<>();


//hour temps
    static MutableLiveData<Integer> hourTempOne = new MutableLiveData<>();
    static MutableLiveData<Integer> hourTempTwo = new MutableLiveData<>();
    static MutableLiveData<Integer> hourTempThree = new MutableLiveData<>();
    static MutableLiveData<Integer> hourTempFour = new MutableLiveData<>();
    static MutableLiveData<Integer> hourTempFive = new MutableLiveData<>();
    static MutableLiveData<Integer> hourTempSix = new MutableLiveData<>();






    public HomeFragmentViewModel() {
        currentTemp.setValue(0);
        currentSunsetTime.setValue("00:00");
        currentSunriseTime.setValue("00:00");
        currentWindSpeed.setValue(0.0);
        currentFeelsLikeTemp.setValue(0);
        //times

        hourTimeOne.setValue("00:00");
        hourTimeTwo.setValue("00:00");
        hourTimeThree.setValue("00:00");
        hourTimeFour.setValue("00:00");
        hourTimeFive.setValue("00:00");
        hourTimeSix.setValue("00:00");

        //temps
        hourTempOne.setValue(0);
        hourTempTwo.setValue(0);
        hourTempThree.setValue(0);
        hourTempFour.setValue(0);
        hourTempFive.setValue(0);
        hourTempSix.setValue(0);
    }
}
