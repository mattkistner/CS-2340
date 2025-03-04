package com.example.sprint1implementation;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import android.widget.TextView;

public class SetupPlayerActivity extends AppCompatActivity {
    private String playerName;
    private int lives;
    private Sprite sprite;
    private static Player newPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        RadioGroup buttonBox = (RadioGroup) findViewById(R.id.radioGroup);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(l -> {

            //
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

            Player newPlayer = new Player(playerName, lives, sprite);

            /*System.out.println("Name: " + newPlayer.getName() + ", Lives: "
            + newPlayer.getLives() + ", Sprite" + newPlayer.getSprite());
            */

            Intent i = new Intent(this, Game.class);
            i.putExtra("newPlayer", (Serializable)  newPlayer);
            startActivity(i);
        });
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
        setSprite(Sprite.BUZZ);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("Buzz Sprite selected!");
    }

    public void upperButton(View view) {
        setSprite(Sprite.RAT);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("RAT Sprite selected!");
    }

    public void alumButton(View view) {
        setSprite(Sprite.TSPRITE);
        TextView title = (TextView) findViewById(R.id.textView5);
        title.setText("T Sprite selected!");
    }

    public static Player getNewPlayer() {
        return newPlayer;
    }


}



