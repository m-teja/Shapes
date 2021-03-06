package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern4;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Projectile;
import com.gerrymatthewnick.randomsideproject.bullethellgame.R;

public class Bullet2 extends Projectile {

    public Handler deleteDelay;

    public int bulletVelocity = 15;
    public int bulletDamage = 200;
    public final int REMOVE_DELAY = 10000;

    public Bullet2(Context con, Cursor cursor) {
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
        super.image.setImageResource(con.getResources().getIdentifier("bullet2", "drawable", con.getPackageName()));
        setImage();

        super.velocity = bulletVelocity;
        super.damage = bulletDamage;
        super.trackCursor = true;

        super.destinationX = destinationX;
        super.destinationY = destinationY;
        startMove();

        deleteDelay = new Handler();
        deleteDelay.postDelayed(runnableDelete, REMOVE_DELAY);

    }

    Runnable runnableDelete = new Runnable() {
        @Override
        public void run() {
            Bullet2.super.delete();
        }
    };

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}