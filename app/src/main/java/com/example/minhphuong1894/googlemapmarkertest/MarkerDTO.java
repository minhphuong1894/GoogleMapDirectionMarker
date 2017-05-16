package com.example.minhphuong1894.googlemapmarkertest;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by minhphuong1894 on 5/15/17.
 */
@IgnoreExtraProperties

public class MarkerDTO {

    String mNameStreet;
    double mLatitudeMarker;
    double mLongtitudeMarker;

    public MarkerDTO( String mNameStreet, double mLatitudeMarker, double mLongtitudeMarker) {

        this.mNameStreet = mNameStreet;
        this.mLatitudeMarker = mLatitudeMarker;
        this.mLongtitudeMarker = mLongtitudeMarker;
    }
}
