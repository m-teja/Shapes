package com.gerrymatthewnick.randomsideproject.bullethellgame;


import android.os.Handler;
import android.widget.ImageView;

public class Projectile {

    public Handler moveImage = new Handler();

    public int velocity;
    public ImageView image;
    public Cursor cursor;


    Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {


            moveImage.postDelayed(moveRunnable, 10);
        }
    };
    //moves projectile by velocity
    public void startMove() {

    }

    //check if projectile is touching cursor
    public void check() {

    }
}
