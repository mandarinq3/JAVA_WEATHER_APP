package com.example.theweatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.TextView;


import com.example.theweatherforecast.databinding.ActivityMainBinding;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    public static Calendar cal = Calendar.getInstance();
    public static  String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
    public static String dateNum = String.valueOf(java.time.LocalDate.now().getDayOfMonth());

    public static Map<String,Object> currentWeather;
    public static  Map<String,Object> hourly;
    public static Map<String, Object> daily;
    public static ArrayList<String> sunsets;



    public static ArrayList<String> sunrises;
    public static ArrayList<Integer> apparentTempMax;
    public static String sunsetTime;
    public static String sunriseTime;
    public static double temperature;
    public static double windSpeed;
    public static double feelsLike;


    public static int weatherCode;
    public static ArrayList<Double> hourlyTemperaturesAll;
    public static ArrayList<String> hourlyTimesAll;
    public static int[] hourlyTemperaturesShort = new int[7];
    public static String[] hourlyTimesShort = new String[7];
    public static final String GET_URL = "https://api.open-meteo.com/v1/forecast?latitude=51.50&longitude=-0.12&hourly=temperature_2m,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,sunrise,sunset&current_weather=true&timezone=auto" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(GET_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ObjectMapper mapper = new ObjectMapper();

                if(response.isSuccessful()){
                    String myResponse = response.body().string();
                    Map<String,Object> map = mapper.readValue(myResponse, new TypeReference<Map<String, Object>>(){});


                    currentWeather = (Map<String, Object>) map.get("current_weather");
                    hourly = (Map<String, Object>) map.get("hourly");
                    daily = (Map<String, Object>) map.get("daily");


                    sunsets = (ArrayList<String>) daily.get("sunset");
                    sunrises = (ArrayList<String>) daily.get("sunrise");

                    apparentTempMax = (ArrayList<Integer>) daily.get("apparent_temperature_max");

                    temperature = (double) currentWeather.get("temperature");
                    windSpeed = Math.round((double) currentWeather.get("windspeed"));

                    String str = String.valueOf(apparentTempMax.get(0));
                    feelsLike = Math.round(Float.valueOf(str));

                    String sunsetDateString = sunsets.get(0);
                    sunsetTime = sunsetDateString.substring(11, sunsetDateString.length() - 0);

                    String sunriseDateString = sunrises.get(0);
                    sunriseTime = sunriseDateString.substring(11,sunriseDateString.length()-0);

                    hourlyTemperaturesAll = (ArrayList<Double>) hourly.get("temperature_2m");
                    hourlyTimesAll = (ArrayList<String>) hourly.get("time");

                    TextView headerMonthView = findViewById(R.id.headerMonth);
                    TextView headerDateView = findViewById(R.id.headerDate);


                    try {
                        setHeaderDate(headerMonthView,headerDateView);
                    }catch (Exception e){
                        System.out.println(e);
                    }




                    try {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH");
                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");


                            int k = Integer.parseInt(now.format(formatter1));
                            for (int i = 0; i<7; i++, k++){
                                LocalDateTime item = LocalDateTime.parse(hourlyTimesAll.get(k));
                                hourlyTimesShort[i]= item.format(formatter2);
                                hourlyTemperaturesShort[i] = (int) Math.round(hourlyTemperaturesAll.get(k));
                            }
                        }
                    }catch (Exception e){
                        System.out.println("ERROR "+e);
                    }

                    MainActivity.this.runOnUiThread(() -> {
                        HomeFragmentViewModel.currentTemp.setValue(hourlyTemperaturesShort[0]);
                        HomeFragmentViewModel.currentSunriseTime.setValue(sunriseTime);
                        HomeFragmentViewModel.currentSunsetTime.setValue(sunsetTime);
                        HomeFragmentViewModel.currentWindSpeed.setValue(windSpeed);
                        HomeFragmentViewModel.currentFeelsLikeTemp.setValue((int) feelsLike);

//                        //hour times
                        HomeFragmentViewModel.hourTimeOne.setValue(hourlyTimesShort[1]);
                        HomeFragmentViewModel.hourTimeTwo.setValue(hourlyTimesShort[2]);
                        HomeFragmentViewModel.hourTimeThree.setValue(hourlyTimesShort[3]);
                        HomeFragmentViewModel.hourTimeFour.setValue(hourlyTimesShort[4]);
                        HomeFragmentViewModel.hourTimeFive.setValue(hourlyTimesShort[5]);
                        HomeFragmentViewModel.hourTimeSix.setValue(hourlyTimesShort[6]);

                        //hour temperatures
                        HomeFragmentViewModel.hourTempOne.setValue(hourlyTemperaturesShort[1]);
                        HomeFragmentViewModel.hourTempTwo.setValue(hourlyTemperaturesShort[2]);
                        HomeFragmentViewModel.hourTempThree.setValue(hourlyTemperaturesShort[3]);
                        HomeFragmentViewModel.hourTempFour.setValue(hourlyTemperaturesShort[4]);
                        HomeFragmentViewModel.hourTempFive.setValue(hourlyTemperaturesShort[5]);
                        HomeFragmentViewModel.hourTempSix.setValue(hourlyTemperaturesShort[6]);
                    });
                }else{
                    System.out.println("FAIL REQUSET");
                }
            }
        });


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navBar.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.day:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.week:
                    replaceFragment(new WeekFragment());
                    break;

                case R.id.cities:
                    replaceFragment(new CitiesFragment());
                    break;

                default:
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


    public void setHeaderDate(TextView month, TextView date){
        month.setText(monthName);
        date.setText(dateNum);
    }
}