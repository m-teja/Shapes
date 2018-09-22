package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class Cursor {

    public Handler postGameDelay = new Handler();

    public final int CURSOR_IMAGE_Y_DISPLACEMENT = 200;
    public final int CURSOR_WIDTH = 32;
    public int health = 1000;
    public boolean active;

    public Context con;
    public ImageView cursorImage;
    public ProgressBar healthbar;

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

    public void takeDamage(int damage) {
        health -= damage;

        healthbar.bringToFront();
        healthbar.setProgress(healthbar.getProgress() - damage);
        if (health <= 0) {
            gameOver();
        }
    }

    Runnable runnableDelay = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(con, PostGameScreen.class);
            intent.putExtra("postGameValue", "Bullets wins");

            con.startActivity(intent);
        }
    };

    public void gameOver() {

        if (active) {
            active = false;
            RelativeLayout rl = ((Activity)con).findViewById(R.id.rlSingleCursor);
            rl.removeView(cursorImage);
            //2 second delay before activity switch
            postGameDelay.postDelayed(runnableDelay, 2000);
        }

    }

    public void init() {
        cursorImage = ((Activity)con).findViewById(R.id.cursor);

        healthbar = ((Activity)con).findViewById(R.id.healthBar);
        active = true;
    }

}