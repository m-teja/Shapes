package com.gerrymatthewnick.randomsideproject.bullethellgame;


import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Projectile {

    public Handler moveImage = new Handler();

    public int velocity;
    public ImageView image;
    public Cursor cursor;

    public RelativeLayout rl;

    public void setImage() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);
        image.setX(200);
        image.setY(200);
        rl.addView(image);

    }

    Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {
            check();
            image.setY(image.getY() + velocity);

            moveImage.postDelayed(moveRunnable, 10);
        }
    };
    //moves projectile by velocity
    public void startMove() {
        moveRunnable.run();

    }

    //check if projectile is touching cursor
    public void check() {

    }
}
