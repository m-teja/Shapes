package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern6;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Projectile;
import com.gerrymatthewnick.randomsideproject.bullethellgame.R;

public class Bullet4 extends Projectile {

    public int bulletVelocity = 30;
    public int bulletDamage = 200;

    public Bullet4(Context con, Cursor cursor) {
        super.con = con;
        super.cursor = cursor;
    }

    public void init(int x, int y, int destinationX, int destinationY) {
        initialX = x;
        initialY = y;

        getScreenHeightWidth();

        //in the future, set this to support all rls
        rl = ((Activity)con).findViewById(R.id.rlSingleCursor);

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("bullet3", "drawable", con.getPackageName()));

        setImage();
        super.velocity = bulletVelocity;
        super.damage = bulletDamage;

        super.destinationX = destinationX;
        super.destinationY = destinationY;
        startMove();

    }

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}