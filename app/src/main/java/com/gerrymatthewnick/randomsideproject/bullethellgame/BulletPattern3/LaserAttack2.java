package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class LaserAttack2 {

    public SharedPreferences singleCursorActive;
    public boolean active;

    public Context con;
    public Cursor cursor;

    public int screenWidth;
    public int screenHeight;

    public Handler attackDelay = new Handler();
    public Handler stopDelay = new Handler();

    public LaserAttack2(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    public void stop() {
        active = false;
    }

    Runnable runnableStop = new Runnable() {
        @Override
        public void run() {
            stop();
        }
    };

    private Runnable runnableAttack = new Runnable() {
        int placement;
        @Override
        public void run() {
            int previous = placement;

            do {
                placement = choosePlacement();
            }
            while(previous == placement);


            Laser2 laser2 = new Laser2(con, cursor);

            laser2.init(placement, 0, screenWidth, screenHeight);

            if (active && singleCursorActive.getBoolean("singleCursorActive", true)) {
                attackDelay.postDelayed(runnableAttack, 1000);
            }
            else {
                attackDelay.removeCallbacksAndMessages(null);
            }
        }
    };

    public int choosePlacement() {
        int choice = (int)Math.floor(Math.random() * 4);

        switch (choice) {

            case 0:
                return screenWidth/8;


            case 1:
                return (screenWidth*3)/8;


            case 2:
                return (screenWidth*5)/8;


            case 3:
                return (screenWidth*7)/8;


            default:
                return (screenWidth/4);

        }
    }

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
