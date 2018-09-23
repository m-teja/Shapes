package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    public void postToSingleCursor(View view) {
        Intent intent = new Intent(this, SingleCursor.class);
        startActivity(intent);
    }

    public void postToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //Prevent back press
    }
}
//TODO bug when play again is pressed fast