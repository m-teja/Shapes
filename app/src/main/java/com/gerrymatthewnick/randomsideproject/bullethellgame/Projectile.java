package com.gerrymatthewnick.randomsideproject.bullethellgame;


import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Projectile {

    public Handler moveImage = new Handler();
    public boolean active = true;

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

            if (active) {
                moveImage.postDelayed(moveRunnable, 20);
            }
            else {
                delete();
            }
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
        Rect cursorRect = new Rect();
        Rect projRect = new Rect();

        cursor.getImage().getHitRect(cursorRect);
        image.getHitRect(projRect);

        if (cursorRect.intersect(projRect)) {
            delete();
        }

    }

    public void delete() {
        active = false;
        moveImage.removeCallbacksAndMessages(null);
        image.setImageBitmap(null);
        rl.removeView(image);
    }
    //TODO fix memory leak
}
