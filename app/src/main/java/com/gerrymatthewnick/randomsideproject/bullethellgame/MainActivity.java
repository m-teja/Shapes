package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainToOnePlayer(View view) {
        Intent intent = new Intent(this, SinglePlayerChoose.class);
        startActivity(intent);
    }

    public void mainToTwoPlayers(View view) {
        Intent intent = new Intent(this, TwoPlayerGame.class);
        startActivity(intent);
    }

    public void mainToInstructions(View view) {
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);
    }


}
