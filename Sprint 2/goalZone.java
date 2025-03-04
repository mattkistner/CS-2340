package com.example.sprint1implementation;

import com.example.sprint1implementation.zone;

public class goalZone extends zone {
    //goal zone at the end. should use width.
    private String name;

    public goalZone(int h, int w, String c) {
        super(true, h, w, c);
        name = "Finish!";
    }

    public String getName() {
        return name;
    }
}