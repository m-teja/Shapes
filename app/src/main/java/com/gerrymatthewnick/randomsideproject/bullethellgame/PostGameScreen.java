package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PostGameScreen extends AppCompatActivity {

    private String postGameMessage;
    private float time;
    private String timeLasted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game_screen);

        getValues();
    }


    public void getValues() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            postGameMessage = extras.getString("postGameValue");
            time = (float)extras.getInt("time")/1000;
            timeLasted = Float.toString(time);
        }

        TextView postGameDisplay = findViewById(R.id.postGameDisplay);
        postGameDisplay.setText(postGameMessage);

        TextView postTimeDisplay = findViewById(R.id.postTimeDisplay);
        postTimeDisplay.setText("Time lasted: " + timeLasted);
    }
}
