package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.widget.ImageView;

public class Bullet1 extends Projectile {

    Context con;
    public ImageView bulletImage;
    public int bulletVelocity = 5;

    public Bullet1 (Context con) {
        this.con = con;
    }

    public void init() {
        bulletImage.setImageResource(con.getResources().getIdentifier("bullet1", "drawable", con.getPackageName()));
        super.image = bulletImage;
        super.velocity = bulletVelocity;


    }
}
