package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
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


    public void setImage() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(lp);

        image.setX(xLeft);
        image.setY(yTop);

        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        image.getLayoutParams().height = yHeight;
        image.getLayoutParams().width = xWidth/10;

        //might need to draw rectangle
        rl.addView(image);

        imageSpawnAnimation();

    }
    public void imageSpawnAnimation() {
        Animation anim = new AlphaAnimation((float)0.5, 0);
        anim.setDuration(100);
        anim.setStartOffset(20);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(10);


        image.startAnimation(anim);
    }


}
