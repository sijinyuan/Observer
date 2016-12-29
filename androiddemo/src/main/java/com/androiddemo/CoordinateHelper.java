package com.androiddemo;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


/**
 * @author coldwait
 * @version
 */
public class CoordinateHelper {
    public CoordinateHelper(Context context, TextView longitude,
                            TextView latitude) {
        this.context = context;
        this.latitude = latitude;
        this.longitude = longitude;


        setLocationParam();
    }


    double lat;
    double lng;
    private LocationManager locationManager;
    private Context context;
    private TextView longitude;
    private TextView latitude;


    public String getLatitude() {
        return String.valueOf(lat);
    }


    public String getLongitude() {
        return String.valueOf(lng);
    }


    private void setLocationParam() {
        try {
            String serviceName = Context.LOCATION_SERVICE;
            locationManager = (LocationManager) context
                    .getSystemService(serviceName);


			/*
			 * locationManager =
			 * (LocationManager)getSystemService(LOCATION_SERVICE);
			 *
			 * String provider=LocationManager.GPS_PROVIDER; Location location =
			 * locationManager.getLastKnownLocation(provider);
			 */


            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_LOW);


            String provider = locationManager.getBestProvider(criteria, true);
            Location location = locationManager.getLastKnownLocation(provider);
            updateWithNewLocation(location);
            // 设置监听器，自动更新的最小时间为间隔1秒，最小位移变化超过5米
            locationManager.requestLocationUpdates(provider, 1000, 5,
                    locationListener);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }


    }


    private final LocationListener locationListener = new LocationListener() {


        public void onLocationChanged(Location location) {
            updateWithNewLocation(location);
        }


        public void onProviderDisabled(String provider) {
            updateWithNewLocation(null);
        }


        public void onProviderEnabled(String provider) {
        }


        public void onStatusChanged(String provider, int status, Bundle extras) {
        }


    };


    private void updateWithNewLocation(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
        } else {
            lat = 0;
            lng = 0;
        }
        latitude.setText(getLatitude());
        longitude.setText(getLongitude());
    }
}
