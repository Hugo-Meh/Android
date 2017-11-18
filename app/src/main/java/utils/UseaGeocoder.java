package utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;

/**
 * Created by samsung on 17/11/2017.
 */

public final class UseaGeocoder {
    Geocoder geocoder;

    public UseaGeocoder(Context context) {
        geocoder = new Geocoder(context);
    }

    public String getCountryName(double lat, double lon){
        String result = null;

        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(lat, lon, 1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (addresses.size() > 0)
        {
            result=addresses.get(0).getCountryName();
        }

        return result;
    }
}
