package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<QuakeItem> {
    public QuakeAdapter(Context context, ArrayList<QuakeItem> quakeList){
        super(context, 0,quakeList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        QuakeItem quakeItem = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quake_item, parent, false);
        }
        TextView magnitudeView = (TextView) convertView.findViewById(R.id.quake_magnitude);
        TextView locationView1 = (TextView) convertView.findViewById(R.id.quake_location1);
        TextView locationView2 = (TextView) convertView.findViewById(R.id.quake_location2);
        TextView dateView = (TextView) convertView.findViewById(R.id.quake_date);
        TextView timeView = (TextView) convertView.findViewById(R.id.quake_time);

        Date date = new Date(quakeItem.getTimeInMs());
       SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
       SimpleDateFormat dateFormatter2 = new SimpleDateFormat("HH:mm:ss");
       String quakeDateFormat = dateFormatter.format(date);
       String quakeTimeFormat = dateFormatter2.format(date);

       String formattedMagnitude = formatMagnitude(quakeItem.getMagnitude());




        magnitudeView.setText(formattedMagnitude);
        locationView1.setText(quakeItem.quakeLocation1);
        locationView2.setText(quakeItem.quakeLocation2);
        dateView.setText(quakeDateFormat);
        timeView.setText(quakeTimeFormat);

        return convertView;


    }
    private  String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
