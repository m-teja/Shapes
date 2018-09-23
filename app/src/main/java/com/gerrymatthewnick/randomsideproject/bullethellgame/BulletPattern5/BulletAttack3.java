package com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.Cursor;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class BulletAttack3 {

    public SharedPreferences singleCursorActive;
    public boolean active;

    public int screenWidth;
    public int screenHeight;

    public Context con;
    public Cursor cursor;

    public Handler attackDelay = new Handler();
    public Handler stopDelay = new Handler();

    public BulletAttack3(Context con, Cursor cursor) {
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

        Bullet3 topLeftToBottomRight = new Bullet3(con, cursor);
        topLeftToBottomRight.init(0, 0, screenWidth*2 - cursor.CURSOR_WIDTH, screenHeight*2 - cursor.CURSOR_WIDTH);

        Bullet3 topRightToBottomLeft = new Bullet3(con, cursor);
        topRightToBottomLeft.init(screenWidth - cursor.CURSOR_WIDTH, 0, 0, screenHeight - cursor.CURSOR_WIDTH);

        Bullet3 middleLeftToMiddleRight = new Bullet3(con, cursor);
        middleLeftToMiddleRight.init(0, (screenHeight/2) - cursor.CURSOR_WIDTH/2, screenWidth, (screenHeight/2) - cursor.CURSOR_WIDTH/2);

        Bullet3 middleRightToMiddleLeft = new Bullet3(con, cursor);
        middleRightToMiddleLeft.init(screenWidth, (screenHeight/2) - cursor.CURSOR_WIDTH/2, 0, (screenHeight/2) - cursor.CURSOR_WIDTH/2);

        Bullet3 topMiddleToBottomMiddle = new Bullet3(con, cursor);
        topMiddleToBottomMiddle.init((screenWidth/2) - cursor.CURSOR_WIDTH/2, 0, (screenWidth/2) - cursor.CURSOR_WIDTH/2, screenHeight);

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
                attackDelay.postDelayed(runnableAttack, 400);
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
