package com.example.sprint1implementation;


import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int lives;
    private Sprite sprite;

    public Player(String name, int lives, Sprite sprite) {
        this.name = name;
        this.lives = lives;
        this.sprite = sprite;
    }

    public Player() {
        this.name = "default";
        this.lives = 3;
        this.sprite = Sprite.ALUMNI;
    }



    public String getName() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getLives() {
        return lives;
    }
}
