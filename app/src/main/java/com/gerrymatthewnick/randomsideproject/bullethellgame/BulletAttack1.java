package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class BulletAttack1 {

    public SharedPreferences singleCursorActive;

    public int screenWidth;
    public int screenHeight;

    public Context con;
    public Cursor cursor;

    public int attackReps = 0;
    public Handler attackDelay = new Handler();

    public BulletAttack1(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }
    public void initAttack() {
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        getScreenHeightWidth();
        runnableAttack.run();
    }
    public void attackPattern() {
        for (int i = 0; i < 4; i++) {
            Bullet1 bullet1 = new Bullet1(con, cursor);
            bullet1.init((int)(((screenWidth/4) * i * Math.random()) + 100), 100);//put x and y here to make attack patterns
        }
    }

    Runnable runnableAttack = new Runnable() {
        @Override
        public void run() {
            attackReps++;

            attackPattern();

            if (attackReps < 100 && singleCursorActive.getBoolean("singleCursorActive", true)) {
                attackDelay.postDelayed(runnableAttack, 500);
            }
            else {
                attackDelay.removeCallbacksAndMessages(null);
            }
        }
    };

    public void getScreenHeightWidth() {
        screenWidth = con.getResources().getDisplayMetrics().widthPixels;
        screenHeight = con.getResources().getDisplayMetrics().heightPixels;
    }
}
