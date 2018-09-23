package com.gerrymatthewnick.randomsideproject.bullethellgame;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class Projectile {

    public Handler moveImage = new Handler();
    public boolean active = true;
    public SharedPreferences singleCursorActive;

    public int initialX;
    public int initialY;
    public int destinationX;
    public int destinationY;
    public float currentVelocityX;
    public float currentVelocityY;
    public boolean trackCursor = false;

    public int velocity;
    public int damage;
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

    public void calcDifference() {

        float currentX = image.getX();
        float currentY = image.getY();

        float differenceX;
        float differenceY;

        if (trackCursor) {
            differenceX = cursor.getX() - currentX;
            differenceY = cursor.getY() - currentY;
        }
        else {
            differenceX = destinationX - currentX;
            differenceY = destinationY - currentY;
        }

        if (differenceX != 0 && differenceY != 0) {
            float differenceXY = (float)Math.sqrt( Math.pow((differenceY), 2) + Math.pow((differenceX), 2));

            float cosAngle = (float)Math.acos(differenceY/differenceXY);
            float sinAngle = (float)Math.asin(differenceX/differenceXY);

            currentVelocityY = (float)(Math.cos(cosAngle) * velocity);
            currentVelocityX = (float)(Math.sin(sinAngle) * velocity);
        }
        else if (differenceX == 0) {

            if (destinationY < currentY) {
                currentVelocityY = -velocity;
            }
            else {
                currentVelocityY = velocity;
            }
        }
        else if (differenceY == 0) {

            if (destinationX < currentX) {
                currentVelocityX = -velocity;
            }
            else {
                currentVelocityX = velocity;
            }
        }

    }

    private Runnable moveRunnable = new Runnable() {
        @Override
        public void run() {
            calcDifference();

            checkCursor();
            checkBounds();
            image.setY(image.getY() + currentVelocityY);
            image.setX(image.getX() + currentVelocityX);


            //Change this later for different activities
            if (active && singleCursorActive.getBoolean("singleCursorActiveActivity", true)) {
                moveImage.postDelayed(moveRunnable, 20);
            }
            else {
                delete();
            }
        }
    };
    //moves projectile by velocity
    public void startMove() {
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        moveRunnable.run();

    }
    public void checkBounds() {
        if (image.getY() > screenHeight || image.getX() < 0 || image.getX() > screenWidth) {
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
            cursor.takeDamage(damage);
        }

    }

    public void delete() {
        active = false;
        moveImage.removeCallbacksAndMessages(null);
        image.setImageBitmap(null);
        rl.removeView(image);
    }

}
