package com.example.sprint1implementation;


import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int lives;
    private Sprite sprite;
    private int score;

    public Player(String name, int lives, Sprite sprite) {
        this.name = name;
        this.lives = lives;
        this.sprite = sprite;
        this.score = 0;
    }

    public Player() {
        this.name = "default";
        this.lives = 3;
        this.sprite = Sprite.BUZZ;
        this.score = 0;
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


    public int getScore() {
        return score;
    }

    public void plusOne() {
        score++;
    }
}
