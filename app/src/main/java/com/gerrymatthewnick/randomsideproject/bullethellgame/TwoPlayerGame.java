package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TwoPlayerGame extends AppCompatActivity {

    public int screenWidth;
    public int screenHeight;

    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_game);

        getScreenHeightWidth();
        initBackgrounds();
    }

    public void initBackgrounds() {
        ImageView backgroundBullets = findViewById(R.id.preStartBulletsSide);
        ImageView backgroundCursor = findViewById(R.id.preStartCursorSide);

        backgroundBullets.setX(0);
        backgroundBullets.setY(0);
        backgroundBullets.getLayoutParams().width = screenWidth;
        backgroundBullets.getLayoutParams().height = screenHeight/2;

        backgroundCursor.setX(0);
        backgroundCursor.setY(screenHeight/2);
        backgroundCursor.getLayoutParams().width = screenWidth;
        backgroundCursor.getLayoutParams().height = screenHeight/2;
    }

    public void getScreenHeightWidth() {
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    public void readyBullets() {
        ImageView background = findViewById(R.id.preStartBulletsSide);
    }

    public void readyPlayer() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:

                if (started) {

                }
                else if (y < screenHeight/2 && !started) {
                    readyBullets();
                }
                else if (y > screenHeight/2 && !started) {
                    readyPlayer();
                }

                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                break;
        }
        return false;
    }
}
