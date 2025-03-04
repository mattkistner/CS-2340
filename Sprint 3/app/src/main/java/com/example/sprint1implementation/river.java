package com.example.sprint1implementation;

public class River extends Zone {
    //width is not relevant here - should extend to full screen
    private String name;

    public River(boolean safe, int h, String c) {
        super(false, h, c);
        name = "Skiles Walkway";
    }

    public String getName() {
        return name;
    }
}