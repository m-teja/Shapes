package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern1.Bullet1;
import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class BulletAttack1 {

    public SharedPreferences singleCursorActive;
    public boolean active;

    public int screenWidth;
    public int screenHeight;

    public Context con;
    public Cursor cursor;

    public Handler attackDelay = new Handler();
    public Handler stopDelay = new Handler();

    public BulletAttack1(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }
    public void initAttack() {
        active = true;
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        getScreenHeightWidth();
        runnableAttack.run();

        stopDelay.postDelayed(runnableStop, 9000);
    }
    public void stop() {
        active = false;
        attackDelay.removeCallbacksAndMessages(null);
    }

    public void attackPattern() {
        for (int i = 1; i < 5; i++) {
            int x = (int)(((screenWidth/4) * i * Math.random()) + 50);

            Bullet1 bullet1 = new Bullet1(con, cursor);
            bullet1.init(x, 0, x, screenHeight);//put x and y here to make attack patterns
        }
    }

    Runnable runnableStop = new Runnable() {
        @Override
        public void run() {
            stop();
        }
    };

    Runnable runnableAttack = new Runnable() {
        @Override
        public void run() {

            attackPattern();

            if (active && singleCursorActive.getBoolean("singleCursorActive", true)) {
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
