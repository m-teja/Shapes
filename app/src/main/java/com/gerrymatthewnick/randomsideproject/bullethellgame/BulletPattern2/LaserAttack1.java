package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern2;

import android.content.Context;
import android.content.SharedPreferences;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class LaserAttack1 {

    public SharedPreferences singleCursorActive;

    public Context con;
    public Cursor cursor;

    public int screenWidth;
    public int screenHeight;

    public LaserAttack1(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    Runnable runnableAttack = new Runnable() {
        @Override
        public void run() {
            Laser1 laser1 = new Laser1(con, cursor);
            //temporary x and y
            laser1.init(100, 0, screenHeight);
        }
    };

    public void initAttack() {
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        getScreenHeightWidth();
        runnableAttack.run();
    }

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}
