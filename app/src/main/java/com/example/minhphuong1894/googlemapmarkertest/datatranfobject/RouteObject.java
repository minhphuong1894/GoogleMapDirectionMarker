package com.example.minhphuong1894.googlemapmarkertest.datatranfobject;

import java.util.List;

/**
 * Created by minhphuong1894 on 5/16/17.
 */

public class RouteObject {
    private List<LegsObject> legs;
    public RouteObject(List<LegsObject> legs) {
        this.legs = legs;
    }
    public List<LegsObject> getLegs() {
        return legs;
    }
}
