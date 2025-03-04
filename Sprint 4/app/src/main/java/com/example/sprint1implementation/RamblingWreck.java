package com.example.sprint1implementation;


public class RamblingWreck extends Vehicle {
    //should also only show up on skiles walkway

    //probably change constructor to fix the implementation of this - want it to be direct
    public Scooter(int height, int width, boolean dir, int speed) {
        super(height, width, dir, speed);
    }
    public buzz(int damage){
        super(1000, 1000, dir, damage);
    }
}