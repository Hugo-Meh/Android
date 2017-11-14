package Entities;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by androidlinux on 10/11/17.
 */

public class MyItem implements ClusterItem {

    private int lat;
    private int lng;

    private final LatLng Position;

    public MyItem(double lat, double lng) {

        Position = new LatLng(lat, lng);
    }

    public MyItem(LatLng position) {
        this.Position = position;
    }

    @Override
    public LatLng getPosition() {

        return Position;
    }
}
