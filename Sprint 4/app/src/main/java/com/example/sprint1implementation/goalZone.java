package com.example.sprint1implementation;

import com.example.sprint1implementation.Zone;

public class GoalZone extends Zone {
    //goal zone at the end. should use width.
    private String name;

    public GoalZone(int h, int w, String c) {
        super(true, h, w, c);
        name = "Finish!";
    }

    public String getName() {
        return name;
    }
}