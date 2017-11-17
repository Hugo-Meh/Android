package Entities;

import java.util.Date;

/**
 * Created by androidlinux on 15/11/17.
 */

public class Photo {
    private int id;
    private double lat;
    private double lon;
    private Date date;
    private String src;

    public Photo(int id, double lat, double lon, Date date, String src) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.src = src;
    }

    public Photo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
