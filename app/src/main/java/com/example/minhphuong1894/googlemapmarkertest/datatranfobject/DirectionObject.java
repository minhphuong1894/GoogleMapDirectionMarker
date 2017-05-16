package com.example.minhphuong1894.googlemapmarkertest.datatranfobject;

import java.util.List;

/**
 * Created by minhphuong1894 on 5/16/17.
 */

public class DirectionObject {
    private List<RouteObject> routes;
    private String status;
    public DirectionObject(List<RouteObject> routes, String status) {
        this.routes = routes;
        this.status = status;
    }
    public List<RouteObject> getRoutes() {
        return routes;
    }
    public String getStatus() {
        return status;
    }
}
