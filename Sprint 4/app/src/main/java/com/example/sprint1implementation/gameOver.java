package com.example.sprint1implementation;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class GameOver extends AppCompatActivity {
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = (Player) getIntent().getSerializableExtra("player");
        setContentView(R.layout.game_over_screen);
        TextView stats = findViewById(R.id.statstext);
        Button exit = findViewById(R.id.exitbtn);
        Button tryAgain = findViewById(R.id.button4);
        stats.setText("Score: " + player.getScore());

        TextView message = findViewById(R.id.textView4);
        if(player.wasWinner()) {
            message.setText("Congratulations! You Won!");
        }

        tryAgain.setOnClickListener(l -> {
            Intent i = new Intent(this, SetupPlayerActivity.class);
            GameOver.this.finish();
            startActivity(i);
        });

        exit.setOnClickListener(l -> {
            GameOver.this.finish();
            finishAffinity();
            System.exit(0);

        });

    }
}
