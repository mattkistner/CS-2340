package com.example.sprint1implementation;

import com.example.sprint1implementation.Zone;

public class Road extends Zone {
    //also doesn't rely on width, but still needs to be max (see parent class)
    private String name;

    public Road(boolean safe, int h, String c) {
        super(false, h, c);
        name = "Bobby Dodd Way";
    }

    public String getName() {
        return name;
    }
}
