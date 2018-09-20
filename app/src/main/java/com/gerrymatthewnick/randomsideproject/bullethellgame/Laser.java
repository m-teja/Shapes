package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.util.Log;
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
        image.getLayoutParams().width = xWidth;

        //might need to draw rectangle
        rl.addView(image);

    }


}
