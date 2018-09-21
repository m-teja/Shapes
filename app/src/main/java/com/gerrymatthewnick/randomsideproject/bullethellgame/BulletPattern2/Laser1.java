package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern2;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Laser;
import com.gerrymatthewnick.randomsideproject.bullethellgame.R;

public class Laser1 extends Laser {

    public final int WIDTH = 25;
    public final int WARNING_DURATION = 2000;
    public final int DURATION = 1200;

    public Laser1 (Context con, Cursor cursor) {
        super.con = con;
        super.cursor = cursor;
    }

    public void init(int xStart, int yStart, int screenHeight) {

        super.image = new ImageView(con);
        super.image.setImageResource(con.getResources().getIdentifier("laser1", "drawable", con.getPackageName()));

        super.warningDuration = WARNING_DURATION;
        super.duration = DURATION;

        super.xLeft = xStart;
        super.xWidth = WIDTH;
        super.yTop = yStart;
        super.yHeight = screenHeight;
        super.rl = ((Activity)con).findViewById(R.id.rlSingleCursor);

        super.setImage();
    }
}
