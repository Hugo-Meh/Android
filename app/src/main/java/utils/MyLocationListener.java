package utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyLocationListener implements LocationListener{
    Context ctx;

    public MyLocationListener(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void onLocationChanged(Location loc)
    {

        loc.getLatitude();
        loc.getLongitude();

        String Text = "My current location is: " +
                "Latitud = " + loc.getLatitude() +
                "Longitud = " + loc.getLongitude();

        Toast.makeText( ctx, Text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider)
    {
        Toast.makeText( ctx, "Gps Disabled", Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onProviderEnabled(String provider)
    {
        Toast.makeText( ctx, "Gps Enabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

}