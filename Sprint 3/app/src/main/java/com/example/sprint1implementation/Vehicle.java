package com.example.sprint1implementation;

public class Vehicle {
    private int height;
    private int width;
    private boolean direction; //this will be right for true, left for false - figured we don't need to make it more complex
    private int speed;
    private int x;
    private int y;
    
    public Vehicle(int height, int width, boolean dir, int speed) {
        this.height = height;
        this.width = width;
        this.direction = dir;
        this.speed = speed;
        //speed is the number of pixels that the image of the vehicle will move on each frame
        //more pixels = moves faster
    }

    public Vehicle() {
        height = 80;
        width = 80;
        direction = true; //right
        speed = 10;
    }

    public int getSpeed() {
        return speed;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public boolean getDirection() {
        return direction;
        //once again, true for right, false for left
    }

    public int getX() {
        return x;
    }
    public void setX(int xTranslate) {
        x = x + xTranslate;
    }

    public int getY() {
        return y;
    }
    public void setY(int yTranslate) {
        //shouldn't need to change y coordinate once it's already been set
        y = y + yTranslate;
    }

    public void moveRight() {
        setX(speed);
    }
    public void moveLeft() {
        setX(speed * -1);
    }
}