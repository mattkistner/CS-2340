package com.example.sprint1implementation;

public class river extends zone {
    //width is not relevant here - should extend to full screen
    private String name;

    public river(boolean safe, int h, String c) {
        super(false, h, c);
        name = "Skiles Walkway";
    }

    public String getName() {
        return name;
    }
}