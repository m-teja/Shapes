package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

public class Bullet1 extends Projectile {

    Context con;
    public int bulletVelocity = 5;

    public Bullet1(Context con, Cursor cursor) {
        this.con = con;
        super.cursor = cursor;
    }

    public void init() {

        //in the future, set this to support all rls
        rl = ((Activity)con).findViewById(R.id.rlSingleCursor);

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("bullet1", "drawable", con.getPackageName()));

        setImage();
        super.velocity = bulletVelocity;
        startMove();

    }
}
//TODO delete image after leaves screen
//TODO detect if activity is active
//TODO check if image touches cursor
