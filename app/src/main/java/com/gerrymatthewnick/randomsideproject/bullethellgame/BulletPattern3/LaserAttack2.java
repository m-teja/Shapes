package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class LaserAttack2 {

    public SharedPreferences singleCursorActive;

    public Context con;
    public Cursor cursor;

    public int screenWidth;
    public int screenHeight;

    public Handler attackDelay = new Handler();

    public LaserAttack2(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    private Runnable runnableAttack = new Runnable() {
        @Override
        public void run() {
            Laser2 laser2 = new Laser2(con, cursor);

            laser2.init(screenWidth/8, 0, screenWidth, screenHeight);

            //if (singleCursorActive.getBoolean("singleCursorActive", true)) {

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
