package com.example.sprint1implementation;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;


import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends AppCompatActivity {
    private Player p;
    private int moveLength = 195;
    private BroadcastReceiver updater;
    private ArrayList<Integer> yPos;
    private boolean onLogs = false;
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
        scooter2.setX(1500);
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (stinger1.getX() < -400) {
                            stinger1.setX(1200);
                        }
                        stinger1.setX(stinger1.getX() - 1);
                        if (scooter1.getX() < -400) {
                            scooter1.setX(1200);
                        }
                        scooter1.setX(scooter1.getX() - 2);
                        if (scooter2.getX() < -400) {
                            scooter2.setX(1200);
                        }
                        scooter2.setX(scooter2.getX() - 2);
                        if (dogs1.getX() < -400) {
                            dogs1.setX(1200);
                        }
                        dogs1.setX(dogs1.getX() - 1);
                        if (dogs2.getX() < -400) {
                            dogs2.setX(1200);
                        }
                        dogs2.setX(dogs2.getX() - 1);
                        if (dogs3.getX() < -400) {
                            dogs3.setX(1500);
                        }
                        dogs3.setX(dogs3.getX() - 2);
                        if (spriteMover.getY() == 809.0 || spriteMover.getY() == 599.0) {
                            spriteMover.setX(spriteMover.getX() - 1);
                        }
                        if (spriteMover.getY() == 389.0) {
                            spriteMover.setX(spriteMover.getX() - 2);
                        }

                        checkCollision(spriteMover, stinger1, scooter1, dogs1, dogs2, dogs3,
                                timer1);
                        lives.setText("Lives: " + p.getLives() + "; Score: " + p.getScore());
                    }
                });
            }
        }, 0, 1);
    }

    private void moveUp(int x, int y, ImageView sprite) {
        System.out.println("moveup");
        if (y >= -1775) {
            sprite.setTranslationY(y - 210);
            if (sprite.getTranslationY() == yPos.get(0)) {
                p.plusOne();
                yPos.remove(0);
                System.out.println("yPos after:" + yPos.toString());
            }

        }

    }

    private void moveDown(int x, int y, ImageView sprite) {
        if (y <= -695) {
            sprite.setTranslationY(y + 210);
        }
    }

    private void moveLeft(int x, int y, ImageView sprite) {
        if (x >= 225) {
            sprite.setTranslationX(x - moveLength);
        }
    }

    private void moveRight(int x, int y, ImageView sprite) {
        if (x <= 695) {
            sprite.setTranslationX(x + moveLength);
        }
    }

    private void checkCollision(ImageView sprite, ImageView stinger, ImageView scooter1,
                                ImageView dogs1, ImageView dogs2, ImageView dogs3, Timer timer) {
        if (sprite.getY() == 1649.0 || sprite.getY() == 1019.0) {
            System.out.println("i am printing this line bcs i have to.");
            //do nothing, no obstacles in these zones
        } else if (sprite.getY() == 1439.0) {
            if (sprite.getX() >= stinger.getX() && sprite.getX() <= stinger.getX() + 300) {
                reset(sprite, timer);
            }
        } else if (sprite.getY() == 1229.0) {
            if (sprite.getX() >= scooter1.getX() && sprite.getX() <= scooter1.getX() + 100) {
                reset(sprite, timer);
            }
        } else if (sprite.getY() == 809.0) {
            if (sprite.getX() < dogs1.getX() - 100 || sprite.getX() > dogs1.getX() + 300) {
                reset(sprite, timer);
            }
        } else if (sprite.getY() == 599.0) {
            if (sprite.getX() < dogs2.getX() || sprite.getX() > dogs2.getX() + 300) {
                reset(sprite, timer);
            }
        } else if (sprite.getY() == 389.0) {
            if (sprite.getX() < dogs3.getX() || sprite.getX() > dogs3.getX() + 300) {
                reset(sprite, timer);
            }
        } else {
            p.winner();
            p.addTo(100);
            quit(timer);
        }
    }

    private void reset(ImageView sprite, Timer timer) {
        if (p.getLives() > 1) {
            sprite.setY(1649);
            sprite.setX(420);
            p.halfScore();
            p.loseALife();

            yPos = new ArrayList<>();

            for (int i = 210; i <= 1680; i += 210) {
                yPos.add(-1 * (500 + i));
            }

        } else {
            quit(timer);
        }
    }

    private void quit(Timer timer) {
        timer.cancel();
        Intent i = new Intent(this, GameOver.class);
        i.putExtra("player", (Serializable)  p);
        startActivity(i);
    }




}
