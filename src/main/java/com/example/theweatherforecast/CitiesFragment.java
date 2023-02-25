package com.example.theweatherforecast;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class CitiesFragment extends Fragment {

    ArrayList<CityObject> cityObjects = new ArrayList<>();

     private void createCityObjectsList(){

         City[] cities = {
                 new City("Ashgabat",  37.95, 58.3833 ),
                 new City( "Paris",  2.35,  48.85 ),
                 new City(  "London",  -0.12,  51.50 ),
                 new City(  "Rome",  12.49,  41.90 ),
                 new City(  "Berlin",  13.40,  52.52 ),
                 new City(  "Madrid",  -3.70,  40.41 ),
                 new City(  "Amsterdam",  4.89,  52.37 ),
                 new City(  "Vienna",  16.37,  48.20 ),
                 new City( "Barcelona",  2.17,  41.38 ),
                 new City(  "Istanbul",  28.97,  41.00 ),
                 new City(  "Dublin",  -6.26,  53.34 ),
                 new City(  "Budapest",  19.04,  47.49 ),
                 new City(  "Oslo",  10.75,  59.91 ),
                 new City(  "Stockholm",  18.07,  59.32 ),
                 new City(  "Zurich",  8.54,  47.37 ),
                 new City(  "Brussels",  4.35,  50.85 ),
                 new City(  "Copenhagen",  12.56,  55.67 ),
                 new City(  "Lisbon",  -9.13,  38.72 ),
                 new City(  "Prague",  14.43,  50.07 ),
                 new City(  "Athens",  23.72,  37.98 ),
         };

         for(int i=0; i<cities.length; i++){

             cityObjects.add(
                     new CityObject(
                             cities[i].getName(),
                             cities[i].getLongitude(),
                             cities[i].getLatitude()
                     )
             );
         }
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_cities);
        createCityObjectsList();

        CityRecyclerViewAdapter adapter = new CityRecyclerViewAdapter(getContext(), cityObjects);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}