package com.example.sprint1implementation;


import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    private Player p;
    private int moveLength = 195;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_gameplay);
        super.onCreate(savedInstanceState);
        p = (Player) getIntent().getSerializableExtra("newPlayer");
        System.out.println(getIntent().getSerializableExtra("newPlayer"));
        ImageView spriteMover =  (ImageView) findViewById(R.id.spriteHolder);
        spriteMover.setTranslationX(420);
        spriteMover.setTranslationY(-500);
        //System.out.println(p.getSprite().toString() + "+kjlk");
        //System.out.println(p.getName() + "+kjlk");
        //System.out.println(p.getLives() + "+kjlk");

        switch (p.getSprite()) {
        case ALUMNI:
            spriteMover.setImageResource(R.drawable.alumni);
            break;
        case UPPERCLASSMAN:
            spriteMover.setImageResource(R.drawable.upperclassman);
            break;
        default:
            spriteMover.setImageResource(R.drawable.freshman);
            break;
        }

        TextView name = (TextView) findViewById(R.id.gameName);
        TextView lives = (TextView) findViewById(R.id.gameLives);
        name.setText("Name: " + p.getName());
        lives.setText("Lives: " + p.getLives());

        ImageButton buttonUp = findViewById(R.id.up);
        buttonUp.setOnClickListener(l -> {
            ImageView sprite = findViewById(R.id.spriteHolder);
            int x = (int) sprite.getTranslationX();
            int y = (int) sprite.getTranslationY();
            moveUp(x, y, sprite);
        });

        ImageButton buttonDown = findViewById(R.id.down);
        buttonDown.setOnClickListener(l -> {
            ImageView sprite = findViewById(R.id.spriteHolder);
            int x = (int) sprite.getTranslationX();
            int y = (int) sprite.getTranslationY();
            moveDown(x, y, sprite);
        });

        ImageButton buttonLeft = findViewById(R.id.left);
        buttonLeft.setOnClickListener(l -> {
            ImageView sprite = findViewById(R.id.spriteHolder);
            int x = (int) sprite.getTranslationX();
            int y = (int) sprite.getTranslationY();
            moveLeft(x, y, sprite);
        });

        ImageButton buttonRight = findViewById(R.id.right);
        buttonRight.setOnClickListener(l -> {
            ImageView sprite = findViewById(R.id.spriteHolder);
            int x = (int) sprite.getTranslationX();
            int y = (int) sprite.getTranslationY();
            moveRight(x, y, sprite);
        });


    }
    /*
    public void onClick(View v){
        ImageView sprite = findViewById(R.id.spriteHolder);
        int x = (int) sprite.getTranslationX();
        int y = (int) sprite.getTranslationY();
        switch(v.getId()) {

            case R.id.up :
                moveUp(x, y, sprite);
                break;
            case R.id.down:
                moveDown(x,y,sprite);
                break;
            case R.id.left:
                moveLeft(x,y,sprite);
                break;
            case R.id.right:
                moveRight(x,y,sprite);
                break;
        }


    }
    */

    private void moveUp(int x, int y, ImageView sprite) {
        System.out.println("moveup");
        if (y >= -1670) {
            sprite.setTranslationY(y - moveLength);
        }
    }

    private void moveDown(int x, int y, ImageView sprite) {
        System.out.println("movedown");
        if (y <= -695) {
            sprite.setTranslationY(y + moveLength);
        }
    }

    private void moveLeft(int x, int y, ImageView sprite) {
        System.out.println("moveleft");
        if (x >= 225) {
            sprite.setTranslationX(x - moveLength);
        }
    }

    private void moveRight(int x, int y, ImageView sprite) {
        System.out.println("moveright");
        if (x <= 695) {
            sprite.setTranslationX(x + moveLength);
        }
    }





}
