package com.inc.playground.playground.utils;

import android.content.Context;

import com.inc.playground.playground.GlobalVariables;
import com.inc.playground.playground.Splash;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }

    public static HashMap<String, Double> getMyLocation(GPSTracker gpsTracker){
        double latitude = 0;
        double longitude = 0;
        // check if GPS enabled
        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();

        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gpsTracker.showSettingsAlert();
        }
        HashMap<String, Double> currentLocation = new HashMap<>();
        currentLocation.put(Constants.LOCATION_LAT, latitude);
        currentLocation.put(Constants.LOCATION_LON, longitude);
        return currentLocation;
    }
}