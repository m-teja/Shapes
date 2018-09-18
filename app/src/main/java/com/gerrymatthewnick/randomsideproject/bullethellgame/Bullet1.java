package com.gerrymatthewnick.randomsideproject.bullethellgame;

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

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("bullet1", "drawable", con.getPackageName()));
        super.velocity = bulletVelocity;


    }
}
