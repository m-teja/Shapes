package com.gerrymatthewnick.randomsideproject.bullethellgame;


import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Projectile {

    public Handler moveImage = new Handler();

    public int initialX;
    public int initialY;

    public int velocity;
    public ImageView image;
    public Cursor cursor;

    public RelativeLayout rl;
    public Context con;

    public int screenHeight;
    public int screenWidth;

    public void setImage() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);
        image.setX(initialX);
        image.setY(initialY);
        rl.addView(image);

    }

    Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {
            checkCursor();
            checkBounds();
            image.setY(image.getY() + velocity);

            moveImage.postDelayed(moveRunnable, 10);
        }
    };
    //moves projectile by velocity
    public void startMove() {
        moveRunnable.run();

    }
    public void checkBounds() {
        if (image.getY() > screenHeight) {
            delete();
        }
    }

    //check if projectile is touching cursor
    public void checkCursor() {

    }

    public void delete() {
        moveImage.removeCallbacksAndMessages(null);
        rl.removeView(image);
    }
}
