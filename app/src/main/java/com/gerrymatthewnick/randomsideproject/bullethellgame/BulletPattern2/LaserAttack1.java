package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class LaserAttack1 {

    public SharedPreferences singleCursorActive;
    public boolean active;

    public Context con;
    public Cursor cursor;

    public int screenWidth;
    public int screenHeight;

    public Handler attackDelay = new Handler();
    public Handler stopDelay = new Handler();

    public LaserAttack1(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    public void stop() {
        active = false;
    }

    private Runnable runnableStop = new Runnable() {
        @Override
        public void run() {
            stop();
        }
    };

    private Runnable runnableAttack = new Runnable() {
        @Override
        public void run() {
            Laser1 laser1 = new Laser1(con, cursor);

            laser1.init((int)cursor.getX() + (cursor.CURSOR_WIDTH/2), 0, screenHeight, 500, screenHeight);

            if (active && singleCursorActive.getBoolean("singleCursorActive", true)) {
                attackDelay.postDelayed(runnableAttack, 1000);
            }
            else {
                attackDelay.removeCallbacksAndMessages(null);
            }

        }
    };

    public void initAttack() {
        active = true;

        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        getScreenHeightWidth();
        runnableAttack.run();

        stopDelay.postDelayed(runnableStop, 10000);
    }

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}
