package com.example.minhphuong1894.googlemapmarkertest.datatranfobject;

import java.util.List;

/**
 * Created by minhphuong1894 on 5/16/17.
 */

public class LegsObject {
    private List<StepsObject> steps;
    public LegsObject(List<StepsObject> steps) {
        this.steps = steps;
    }
    public List<StepsObject> getSteps() {
        return steps;
    }
}
