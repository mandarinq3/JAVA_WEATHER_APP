package com.example.theweatherforecast;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //----------views---------------------
        TextView sunsetTextView = view.findViewById(R.id.sunsetTextView);
        TextView dayTextView;
        TextView feelsLikeTextView = view.findViewById(R.id.feelsLikeTextView);
        TextView temperatureTextView = view.findViewById(R.id.temperatureTextView);
        View cityNameTextView;
        TextView windSpeedTextView = view.findViewById(R.id.windSpeedTextView);
        TextView sunriseTextView = view.findViewById(R.id.sunriseTextView);
        ImageView weatherIconImageView;

        //time text views
        TextView hourTimeOne = view.findViewById(R.id.hourTimeOne);
        TextView hourTimeTwo = view.findViewById(R.id.hourTimeTwo);
        TextView hourTimeThree = view.findViewById(R.id.hourTimeThree);
        TextView hourTimeFour = view.findViewById(R.id.hourTimeFour);
        TextView hourTimeFive = view.findViewById(R.id.hourTimeFive);
        TextView hourTimeSix = view.findViewById(R.id.hourTimeSix);

        //temp text views
        TextView hourTempOne = view.findViewById(R.id.hourTempOne);
        TextView hourTempTwo = view.findViewById(R.id.hourTempTwo);
        TextView hourTempThree = view.findViewById(R.id.hourTempThree);
        TextView hourTempFour = view.findViewById(R.id.hourTempFour);
        TextView hourTempFive = view.findViewById(R.id.hourTempFive);
        TextView hourTempSix = view.findViewById(R.id.hourTempSix);



        //----------------------------------------------

        HomeFragmentViewModel.currentTemp.observe(getViewLifecycleOwner(), aDouble -> temperatureTextView.setText(Math.round(HomeFragmentViewModel.currentTemp.getValue()) + " °C"));

        HomeFragmentViewModel.currentSunriseTime.observe(getViewLifecycleOwner(),s ->  sunriseTextView.setText(String.valueOf(
                HomeFragmentViewModel.currentSunriseTime.getValue()
        )));
        HomeFragmentViewModel.currentSunsetTime.observe(getViewLifecycleOwner(), s -> sunsetTextView.setText(String.valueOf(
                HomeFragmentViewModel.currentSunsetTime.getValue()
        )));

        HomeFragmentViewModel.currentWindSpeed.observe(getViewLifecycleOwner(), aDouble -> windSpeedTextView.setText(Math.round(HomeFragmentViewModel.currentWindSpeed.getValue()) + " km/h"));

        HomeFragmentViewModel.currentFeelsLikeTemp.observe(getViewLifecycleOwner(), aDouble -> feelsLikeTextView.setText(
               HomeFragmentViewModel.currentFeelsLikeTemp.getValue() +" °C"
        ));


        //times
        HomeFragmentViewModel.hourTimeOne.observe(getViewLifecycleOwner(), integer -> hourTimeOne.setText(
                HomeFragmentViewModel.hourTimeOne.getValue()
        ));
        HomeFragmentViewModel.hourTimeTwo.observe(getViewLifecycleOwner(), integer -> hourTimeTwo.setText(
                HomeFragmentViewModel.hourTimeTwo.getValue()
        ));
        HomeFragmentViewModel.hourTimeThree.observe(getViewLifecycleOwner(), integer -> hourTimeThree.setText(
                HomeFragmentViewModel.hourTimeThree.getValue()
        ));

        HomeFragmentViewModel.hourTimeFour.observe(getViewLifecycleOwner(), integer -> hourTimeFour.setText(
                HomeFragmentViewModel.hourTimeFour.getValue()
        ));

        HomeFragmentViewModel.hourTimeFive.observe(getViewLifecycleOwner(), integer -> hourTimeFive.setText(
                HomeFragmentViewModel.hourTimeFive.getValue()
        ));

        HomeFragmentViewModel.hourTimeSix.observe(getViewLifecycleOwner(), integer -> hourTimeSix.setText(
                HomeFragmentViewModel.hourTimeSix.getValue()
        ));


        //temps
        HomeFragmentViewModel.hourTempOne.observe(getViewLifecycleOwner(), integer -> hourTempOne.setText(
                HomeFragmentViewModel.hourTempOne.getValue() +" °C"
        ));
        HomeFragmentViewModel.hourTempTwo.observe(getViewLifecycleOwner(), integer -> hourTempTwo.setText(
                HomeFragmentViewModel.hourTempTwo.getValue() +" °C"
        ));
        HomeFragmentViewModel.hourTempThree.observe(getViewLifecycleOwner(), integer -> hourTempThree.setText(
                HomeFragmentViewModel.hourTempThree.getValue() +" °C"
        ));

        HomeFragmentViewModel.hourTempFour.observe(getViewLifecycleOwner(), integer -> hourTempFour.setText(
                HomeFragmentViewModel.hourTempFour.getValue() +" °C"
        ));

        HomeFragmentViewModel.hourTempFive.observe(getViewLifecycleOwner(), integer -> hourTempFive.setText(
                HomeFragmentViewModel.hourTempFive.getValue() +" °C"
        ));

        HomeFragmentViewModel.hourTempSix.observe(getViewLifecycleOwner(), integer -> hourTempSix.setText(
                HomeFragmentViewModel.hourTempSix.getValue() +" °C"
        ));
    }
}