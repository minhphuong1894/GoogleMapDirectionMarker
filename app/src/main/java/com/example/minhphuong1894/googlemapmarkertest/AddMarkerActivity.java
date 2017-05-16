package com.example.minhphuong1894.googlemapmarkertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * Created by minhphuong1894 on 5/15/17.
 */

public class AddMarkerActivity extends AppCompatActivity {
    double mLongtitude,mLatitude;
    TextView mTextviewLatitude,mTextviewLongtitude,mTextviewString;
    String mLatitudeString;
    Button mButtonAddNewMarkers;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String mMarkersID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_marker_activity);
        Intent intent = getIntent();
        mLatitude = intent.getDoubleExtra("MARKER_LATITUDE",mLatitude);
        mLongtitude = intent.getDoubleExtra("MARKER_LONGITUDE",mLongtitude);
        mLatitudeString = intent.getStringExtra("MARKER_STRING");
        FirebaseApp.initializeApp(this);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("markers");


        mTextviewLatitude = (TextView)findViewById(R.id.textview_id_show_latitude);
        mTextviewLongtitude = (TextView)findViewById(R.id.textview_id_show_longtitude);
        mTextviewString = (TextView)findViewById(R.id.textview_id_show_name);
        mButtonAddNewMarkers = (Button)findViewById(R.id.button_add_marker) ;

        mTextviewLatitude.setText(String.valueOf(mLatitude));
        mTextviewLongtitude.setText(String.valueOf(mLongtitude));
        mTextviewString.setText(mLatitudeString);
        inithandle();


    }

    void inithandle(){
        mButtonAddNewMarkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestreet;
                double latitude,longtitude;
                namestreet = mTextviewString.getText().toString();
                latitude = Double.parseDouble(mTextviewLatitude.getText().toString());
                longtitude = Double.parseDouble(mTextviewLongtitude.getText().toString());

                onAddNewMarkers(namestreet,latitude,longtitude);
                Toast.makeText(AddMarkerActivity.this, "You Complete new Marker!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    void onAddNewMarkers(String nameStreet,double longtitude,double latitude){
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(mMarkersID)) {
            mMarkersID = mFirebaseDatabase.push().getKey();
        }

        MarkerDTO markers = new MarkerDTO(nameStreet,longtitude, latitude);

        mFirebaseDatabase.child(mMarkersID).setValue(markers);

//        addUserChangeListener();
    }


}
