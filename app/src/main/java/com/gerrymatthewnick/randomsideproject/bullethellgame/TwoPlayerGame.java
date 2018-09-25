package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class TwoPlayerGame extends AppCompatActivity {

    public int screenWidth;
    public int screenHeight;

    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_game);

        getScreenHeightWidth();
    }

    public void getScreenHeightWidth() {
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    public void readyBullets() {

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
