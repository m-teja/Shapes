package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class Cursor {

    public Handler postGameDelay = new Handler();
    public Chronometer timer;

    public final int CURSOR_IMAGE_Y_DISPLACEMENT = 200;
    public final int CURSOR_WIDTH = 32;
    public int health = 1000;
    public boolean active;

    public ImageView background;
    public int screenWidth;
    public int screenHeight;

    public Context con;
    public ImageView cursorImage;

    public Cursor (Context con) {
        this.con = con;
    }

    public ImageView getImage() {
        return cursorImage;
    }

    public float getX() {
        return cursorImage.getX();
    }

    public float getY() {
        return cursorImage.getY();
    }

    public void setX(float x) {
        cursorImage.setX(x);
    }

    public void setY(float y) {
        cursorImage.setY(y - CURSOR_IMAGE_Y_DISPLACEMENT);
    }

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }

    public void initBackground() {
        background  = new ImageView(con);

        background.setImageResource(con.getResources().getIdentifier("background", "drawable", con.getPackageName()));
        background.setX(0);
        background.setY(0);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        background.setLayoutParams(lp);
        background.setAdjustViewBounds(true);
        background.setScaleType(ImageView.ScaleType.CENTER_CROP);
        background.getLayoutParams().width = screenWidth;
        background.getLayoutParams().height = 0;
        ((RelativeLayout)((Activity)con).findViewById(R.id.rlSingleCursor)).addView(background);

        cursorImage.bringToFront();
    }

    public void takeDamage(int damage) {
        health -= damage;

        background.getLayoutParams().height = (int)(screenHeight - (screenHeight * ((float)health/1000)));

        if (health <= 0) {
            gameOver();
        }
    }

    Runnable runnableDelay = new Runnable() {
        @Override
        public void run() {
            int elapsedMillis = (int) (SystemClock.elapsedRealtime() - timer.getBase());

            Intent intent = new Intent(con, PostGameScreen.class);
            intent.putExtra("postGameValue", "Bullets wins");
            intent.putExtra("time", elapsedMillis);

            con.startActivity(intent);
        }
    };

    public void gameOver() {

        if (active) {
            active = false;
            timer.stop();

            RelativeLayout rl = ((Activity)con).findViewById(R.id.rlSingleCursor);
            rl.removeView(cursorImage);
            //2 second delay before activity switch
            postGameDelay.postDelayed(runnableDelay, 2000);
        }

    }

    public void init() {
        getScreenHeightWidth();
        cursorImage = ((Activity)con).findViewById(R.id.cursor);
        initBackground();
        timer = new Chronometer(con);
        timer.start();

        active = true;
    }

}
//TODO add cursor die animation