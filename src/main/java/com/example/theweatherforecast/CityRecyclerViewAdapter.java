package com.example.theweatherforecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityRecyclerViewAdapter extends RecyclerView.Adapter<CityRecyclerViewAdapter.CityViewHolder> {

    Context context;
    ArrayList<CityObject> cityObjects;

    public CityRecyclerViewAdapter(Context context, ArrayList<CityObject> cityObjects) {
        this.context = context;
        this.cityObjects = cityObjects;
    }

    @NonNull
    @Override
    public CityRecyclerViewAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent, false);
        return new CityRecyclerViewAdapter.CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityRecyclerViewAdapter.CityViewHolder holder, int position) {
        String cords;
        cords = cityObjects.get(position).getLongitude()+"_"+cityObjects.get(position).getLatitude();
        holder.tv_city_name.setText(cityObjects.get(position).getCityName());
        holder.tv_city_name.setTag(cords);
        holder.tv_city_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(view.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityObjects.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView tv_city_name;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_city_name = itemView.findViewById(R.id.tv_city_name);
        }
    }
}
