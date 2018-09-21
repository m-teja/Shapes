package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class Cursor {

    public Handler postGameDelay = new Handler();

    public final int CURSOR_IMAGE_Y_DISPLACEMENT = 200;
    public int health = 100;

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
        RelativeLayout rl = ((Activity)con).findViewById(R.id.rlSingleCursor);
        rl.removeView(cursorImage);
        //2 second delay before activity switch
        postGameDelay.postDelayed(runnableDelay, 2000);
    }

    public void init() {
        cursorImage = ((Activity)con).findViewById(R.id.cursor);
        healthbar = ((Activity)con).findViewById(R.id.healthBar);
    }

}
//TODO cursor still remains after death