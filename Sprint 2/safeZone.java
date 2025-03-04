package com.example.sprint1implementation;

public class safeZone extends zone {
    //will also be the start zone (at the bottom of the screen)
    //should be able to implement width to place between the tiles of goal at the end
    private String name;

    public safeZone(int h, int w, String c) {
        super(true, h, w, c);
        name = "Tech Green";
    }

    public String getName() {
        return name;
    }
}