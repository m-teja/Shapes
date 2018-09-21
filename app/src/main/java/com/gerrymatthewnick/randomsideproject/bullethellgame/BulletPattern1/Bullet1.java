package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern1;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Projectile;
import com.gerrymatthewnick.randomsideproject.bullethellgame.R;

public class Bullet1 extends Projectile {

    public int bulletVelocity = 10;
    public int bulletDamage = 50;

    public Bullet1(Context con, Cursor cursor) {
        super.con = con;
        super.cursor = cursor;
    }

    public void init(int x, int y) {
        initialX = x;
        initialY = y;

        getScreenHeightWidth();

        //in the future, set this to support all rls
        rl = ((Activity)con).findViewById(R.id.rlSingleCursor);

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("bullet1", "drawable", con.getPackageName()));

        setImage();
        super.velocity = bulletVelocity;
        super.damage = bulletDamage;
        startMove();

    }

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}
//TODO check if image touches cursor
//TODO fix second time playing crash