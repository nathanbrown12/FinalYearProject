package com.example.nathan.sportsinjuryidentification;

import android.app.Activity;
import android.os.Bundle;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;

import java.util.function.ToDoubleBiFunction;

public class MyLocation {

    Context mContext;
    public MyLocation() {
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    public Location getLocation(){
        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)mContext.getSystemService(context);

        String provider = LocationManager.GPS_PROVIDER;
        //ToDo FIX THIS
        Location location = locationManager.getLastKnownLocation(provider);

        return location;
    }

    public String updateWithNewLocation(Location location) {
        String latLongString;

        if (location != null){
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            latLongString = "Lat:" + lat + "\nLong:" + lng;
        }else{
            latLongString = "No Location";
        }

        return latLongString;
    }
}