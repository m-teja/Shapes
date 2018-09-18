package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.app.Activity;
import android.content.Context;

import android.widget.ImageView;

public class Cursor {

    public final int CURSOR_IMAGE_Y_DISPLACEMENT = 200;

    public Context con;
    public ImageView cursorImage;

    public Cursor (Context con) {
        this.con = con;
    }

    public void setX(float x) {
        cursorImage.setX(x);
    }

    public void setY(float y) {
        cursorImage.setY(y - CURSOR_IMAGE_Y_DISPLACEMENT);
    }

    public void init() {
        cursorImage = ((Activity)con).findViewById(R.id.cursor);
    }

}
