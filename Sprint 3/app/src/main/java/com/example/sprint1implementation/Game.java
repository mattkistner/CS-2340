package com.example.sprint1implementation;


import android.content.BroadcastReceiver;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Game extends AppCompatActivity {
    private Player p;
    private int moveLength = 195;
    private BroadcastReceiver updater;
    private ArrayList<Integer> yPos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_gameplay);
        super.onCreate(savedInstanceState);
        p = (Player) getIntent().getSerializableExtra("newPlayer");
        System.out.println(getIntent().getSerializableExtra("newPlayer"));
        ImageView spriteMover =  (ImageView) findViewById(R.id.spriteHolder);
        spriteMover.setTranslationX(420);
        spriteMover.setTranslationY(-500);

        yPos = new ArrayList<>();

        for (int i = 210; i <= 1680; i += 210) {
            yPos.add(-1 * (500 + i));
        }

        System.out.println("yPos: " + yPos.toString());


        //spawning new instances of the different vehicles on roads
        Car car = new Car(80, 80, true, 20);

        StingerBus stinger = new StingerBus(80, 240, false, 30);

        ImageView stinger1 = (ImageView) findViewById(R.id.stinger1);
        stinger1.setImageResource(R.drawable.stinger);
        stinger1.setTranslationX(1100);
        stinger1.setTranslationY(-920);
        stinger1.bringToFront();


        ImageView scooter1 = (ImageView) findViewById(R.id.scooter1);
        scooter1.setImageResource(R.drawable.scooter);
        scooter1.setTranslationX(1100);
        scooter1.setTranslationY(-1340);
        scooter1.bringToFront();

        ImageView scooter2 = (ImageView) findViewById(R.id.scooter2);
        scooter2.setImageResource(R.drawable.scooter);
        scooter2.setTranslationX(1685);
        scooter2.setTranslationY(-1550);
        scooter2.bringToFront();


        ImageView dogs1 = (ImageView) findViewById(R.id.dogs1);
        dogs1.setImageResource(R.drawable.dogs);
        dogs1.setTranslationX(1100);
        dogs1.setTranslationY(-2180);
        dogs1.bringToFront();

        ImageView dogs2 = (ImageView) findViewById(R.id.dogs2);
        dogs2.setImageResource(R.drawable.dogs);
        dogs2.setTranslationX(1100);
        dogs2.setTranslationY(-2600);
        dogs2.bringToFront();

        ImageView dogs3 = (ImageView) findViewById(R.id.dogs3);
        dogs3.setImageResource(R.drawable.dogs);
        dogs3.setTranslationX(1100);
        dogs3.setTranslationY(-3010);
        dogs3.bringToFront();
        //spawning for the vehicles on the rivers
        Scooter scooter = new Scooter(80, 80, true, 10);
        Bike bike = new Bike(10, 160, false, 20);
        switch (p.getSprite()) {
        case TSPRITE:
            spriteMover.setImageResource(R.drawable.tsprite);
            break;
        case BUZZ:
            spriteMover.setImageResource(R.drawable.buzzsprite);
            break;
        default:
            spriteMover.setImageResource(R.drawable.ratssprite);
            break;
        }
        TextView name = (TextView) findViewById(R.id.gameName);
        TextView lives = (TextView) findViewById(R.id.gameLives);
        name.setText("Name: " + p.getName());
        lives.setText("Lives: " + p.getLives() + "; Score: " + p.getScore());
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
        Animation move = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f);
        move.setDuration(2000);
        move.setRepeatCount(-1);
        move.setRepeatMode(Animation.INFINITE);
        move.setInterpolator(new LinearInterpolator());
        stinger1.setAnimation(move);
        Animation move2 = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f);
        move2.setDuration(4000);
        move2.setRepeatCount(-1);
        move2.setRepeatMode(Animation.INFINITE);
        move2.setInterpolator(new LinearInterpolator());
        Animation move3 = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f);
        move3.setDuration(5000);
        move3.setRepeatCount(-1);
        move3.setRepeatMode(Animation.INFINITE);
        move3.setInterpolator(new LinearInterpolator());
        Animation move4 = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f);
        move4.setDuration(6000);
        move4.setRepeatCount(-1);
        move4.setRepeatMode(Animation.INFINITE);
        move4.setInterpolator(new LinearInterpolator());
        scooter1.setAnimation(move2);
        scooter2.setAnimation(move2);
        dogs1.setAnimation(move3);
        dogs2.setAnimation(move4);
        dogs3.setAnimation(move3);
    }

    //see deleted code file lines 89-112

    private void moveUp(int x, int y, ImageView sprite) {
        System.out.println("moveup");
        if (y >= -1775) {
            sprite.setTranslationY(y - 210);
            if (sprite.getTranslationY() == yPos.get(0)) {
                updateScore();
                yPos.remove(0);
                System.out.println("yPos after:" + yPos.toString());
            }

        }

    }

    private void moveDown(int x, int y, ImageView sprite) {
        System.out.println("movedown");
        if (y <= -695) {
            sprite.setTranslationY(y + 210);
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

    private void updateScore() {
        p.plusOne();
        TextView lives = (TextView) findViewById(R.id.gameLives);
        lives.setText("Lives: " + p.getLives() + "; Score: " + p.getScore());
    }



}
