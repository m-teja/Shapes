package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Laser {

    public Context con;
    public RelativeLayout rl;

    public ImageView image;
    public Cursor cursor;

    public int xLeft;
    public int xWidth;
    public int yTop;
    public int yHeight;

    Handler laserAppearDelay;

    public void setImage() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);

        image.setX(xLeft);
        image.setY(yTop);

        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        image.getLayoutParams().height = yHeight;
        image.getLayoutParams().width = xWidth/5;

        //might need to draw rectangle
        rl.addView(image);

        imageSpawnAnimation();

    }
    public void imageSpawnAnimation() {
        int repeatCount = 8;

        Animation anim = new AlphaAnimation(0, (float)1.0);
        anim.setDuration(100);
        anim.setStartOffset(20);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(repeatCount);

        image.animate().setDuration(1500).withEndAction(new Runnable() {
            @Override
            public void run() {
                laserAppearDelay = new Handler();

                image.setAlpha((float)0.0);
                image.getLayoutParams().width = xWidth;
                laserAppearDelay.postDelayed(runnablePostSpawnAnimation, 1500);


            }
        }).start();

        image.startAnimation(anim);
    }

    Runnable runnablePostSpawnAnimation = new Runnable() {
        @Override
        public void run() {

            image.setAlpha((float)1.0);

        }
    };



}
