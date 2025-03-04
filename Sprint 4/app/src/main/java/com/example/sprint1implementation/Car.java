package com.example.sprint1implementation;

import com.example.sprint1implementation.Vehicle;

public class Car extends Vehicle {
    //should only show up on roads
    //proabably change constructor to fix the implementation of this - want it to be direct
    public Car(int height, int width, boolean dir, int speed) {
        super(height, width, dir, speed);
    }
}