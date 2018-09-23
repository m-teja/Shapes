package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SinglePlayerChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_mode);
    }

    public void chooseToBullet(View view) {
        Intent intent = new Intent(this, SingleBullet.class);
        startActivity(intent);
    }

    public void chooseToCursor(View view) {
        Intent intent = new Intent(this, SingleCursor.class);
        startActivity(intent);
    }
}
