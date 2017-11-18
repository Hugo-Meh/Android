package manager;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.ClusterManager;

import Entities.Photo;

/**
 * Created by androidlinux on 17/11/17.
 */

public class PersoClusterManager extends ClusterManager<Photo> {

    public PersoClusterManager(Context context, GoogleMap map) {
        super(context, map);
    }

    public PersoClusterManager(Context context, GoogleMap map, MarkerManager markerManager) {
        super(context, map, markerManager);
    }

    
}
