package com.example.sprint1implementation;

public class Zone {
    private int width; //the width on the screen (some will bee full screen width)
    private int height; //the height on the screen (vertical)
    private boolean safe;
    private String color; //this will be a string of the hexcode for the color


    public Zone(boolean s, int w, int h, String c) {
        safe = s;
        width = w;
        height = h;
        color = c;
    }

    public Zone(boolean s, int h, String c) {
        this(s, 1000, h, c);
        //this should be used for any zone that doesn't require width (safe, river, road)
        //1000 is just assuming that the pixel width will extend beyond the edges of the screen
    }



    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean getSafe() {
        return safe;
    }

    public String getColor() {
        return color;
    }
}