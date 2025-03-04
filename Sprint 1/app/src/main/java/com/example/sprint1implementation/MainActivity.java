package com.example.sprint1implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private String playerName;
private int lives;
private Sprite sprite;
private player newPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void moveToConfig(View view) {
        setContentView(R.layout.activity_config);

        Button subBttn = (Button) findViewById(R.id.button2);
        subBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup buttonBox = (RadioGroup) findViewById(R.id.radioGroup);
                int radioButtonId = buttonBox.getCheckedRadioButtonId();
                View radioButtonChosen = buttonBox.findViewById(radioButtonId);
                int conditional = buttonBox.indexOfChild(radioButtonChosen);

                if (conditional == 0) {
                    lives = 3;
                } else if (conditional == 1) {
                    lives = 2;
                } else {
                    lives = 1;
                }

                EditText boxName = (EditText) findViewById(R.id.enterName);
                playerName = boxName.getText().toString();

                moveToPlay();


            }
        });

    }

    public void moveToPlay() {
        newPlayer = new player(playerName, lives, sprite);
        gameplaySetup();
    }

    private void gameplaySetup() {
        setContentView(R.layout.activity_gameplay);

        TextView box1 = (TextView)findViewById(R.id.gameName);
        box1.setText(gameplayNameText() + "; " + gameplayLivesText());


        ImageView spriteMover = (ImageView) findViewById(R.id.spriteHolder);

        switch(newPlayer.getSprite()) {
            case ALUMNI:
                spriteMover.setImageResource(R.mipmap.alumni);
                break;
            case UPPERCLASSMAN:
                spriteMover.setImageResource(R.mipmap.upperclassman);
                break;
            default:
                spriteMover.setImageResource(R.mipmap.freshman);
        }

    }

    public String gameplayNameText() {
        return "Name: " + newPlayer.getName();
    }

    public String gameplayLivesText() {
        return "Lives: " + newPlayer.getLives();
    }

    public void setSprite(Sprite newSprite) {
        sprite = newSprite;
    }

    public void freshButton(View view) {
        setSprite(Sprite.FRESHMAN);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("Freshman Sprite selected!");
        System.out.println("freshmen hit");
    }

    public void upperButton(View view) {
        setSprite(Sprite.UPPERCLASSMAN);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("Upperclassman Sprite selected!");
    }

    public void alumButton(View view) {
        setSprite(Sprite.ALUMNI);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("Alumnus Sprite selected!");
    }

}