package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class Laser {

    public Context con;
    public RelativeLayout rl;
    public SharedPreferences singleCursorActive;

    public boolean collide = false;
    public boolean active = true;
    public int damage;

    public ImageView image;
    public Cursor cursor;

    public int xLeft;
    public int xWidth;
    public int yTop;
    public int yHeight;

    public int warningDuration;
    public int duration;
    public int warningWidth;

    Handler checkCollision;
    Handler laserAppearDelay;
    Handler deleteDelay;

    public void setImage() {
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);

        image.setX(xLeft - warningWidth/2);
        image.setY(yTop);

        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        image.getLayoutParams().height = yHeight;
        image.getLayoutParams().width = warningWidth;

        //might need to draw rectangle
        rl.addView(image);

        imageSpawnAnimation();

    }
    public void imageSpawnAnimation() {
        int repeatCount = 8;

        Animation anim = new AlphaAnimation(0, (float)0.5);
        anim.setDuration(100);
        anim.setStartOffset(20);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(repeatCount);

        image.animate().setDuration(warningDuration /4 * 3).withEndAction(new Runnable() {
            @Override
            public void run() {
                laserAppearDelay = new Handler();

                image.setAlpha((float)0.0);
                image.getLayoutParams().width = xWidth;
                laserAppearDelay.postDelayed(runnablePostSpawnAnimation, warningDuration /4);


            }
        }).start();

        image.startAnimation(anim);
    }

    private Runnable runnablePostSpawnAnimation = new Runnable() {
        @Override
        public void run() {
            deleteDelay = new Handler();

            runnableCheckCursor.run();
            collide = true;
            image.setAlpha((float)1.0);
            deleteDelay.postDelayed(runnableDeleteLaser, duration);
        }
    };

    private Runnable runnableDeleteLaser = new Runnable() {
        @Override
        public void run() {
            delete();
        }
    };

    private Runnable runnableCheckCursor = new Runnable() {
        @Override
        public void run() {
            checkCollision = new Handler();

            checkCursor();
            if (active && singleCursorActive.getBoolean("singleCursorActiveActivity", true)) {
                checkCollision.postDelayed(runnableCheckCursor, damage);
            }
            else {
                delete();
            }
        }
    };

    public void delete() {
        collide = false;
        image.setImageBitmap(null);
        rl.removeView(image);
        checkCollision.removeCallbacksAndMessages(null);
    }


    public void checkCursor() {
        Rect cursorRect = new Rect();
        Rect laserRect = new Rect();

        cursor.getImage().getHitRect(cursorRect);
        image.getHitRect(laserRect);

        if (cursorRect.intersect(laserRect) && collide) {
            cursor.takeDamage(damage);
        }

    }



}
//TODO remake code so it lasers go towards a position for horizontal and etc