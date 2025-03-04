package com.example.sprint1implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.button);

        start.setOnClickListener(e -> {
            Intent i = new Intent(this, SetupPlayerActivity.class);
            startActivity(i);
        });

        /*
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SetupPlayerActivity.class);
                startActivity(i);
            }
         });
         */


    }

    public void moveToConfig(View view) {
        Intent i = new Intent(this, SetupPlayerActivity.class);
        startActivity(i);
    }
    /*
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
                    sprite = Sprite.ALUMNI;
                } else if (conditional == 1) {
                    lives = 2;
                    sprite = Sprite.FRESHMAN;
                } else {
                    sprite = Sprite.UPPERCLASSMAN;
                    lives = 1;
                }

                EditText boxName = (EditText) findViewById(R.id.enterName);
                playerName = boxName.getText().toString();
                if(playerName == "") {
                    playerName = "your mom";
                }
                newPlayer = new player(playerName, lives, sprite);

            }
        });
        setContentView(new Game(this));
        //pass in player

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
    */
}