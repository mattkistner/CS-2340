package com.example.sprint1implementation;

public class player {
    private String name;
    private int lives;
    private Sprite sprite;

    public player(String name, int lives, Sprite sprite) {
        this.name = name;
        this.lives = lives;
        this.sprite = sprite;
    }

    public player(){
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

    public int getLives(){
        return lives;
    }
}
