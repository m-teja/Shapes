package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern3;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Laser;
import com.gerrymatthewnick.randomsideproject.bullethellgame.R;

public class Laser2 extends Laser {

    public int width = 0;
    public final int WARNING_DURATION = 2000;
    public final int DURATION = 1800;
    public final int DAMAGE= 20;

    public Laser2 (Context con, Cursor cursor) {
        super.con = con;
        super.cursor = cursor;
    }

    public void init(int xStart, int yStart, int screenWidth, int screenHeight) {

        width = screenWidth/4;

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("laser2", "drawable", con.getPackageName()));

        super.warningDuration = WARNING_DURATION;
        super.duration = DURATION;
        super.damage = DAMAGE;

        super.xLeft = xStart;
        super.xWidth = width;
        super.yTop = yStart;
        super.yHeight = screenHeight;
        super.rl = ((Activity)con).findViewById(R.id.rlSingleCursor);

        super.setImage();
    }
}
