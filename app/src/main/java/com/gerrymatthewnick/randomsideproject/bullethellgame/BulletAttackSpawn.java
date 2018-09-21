package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern1.BulletAttack1;
import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern2.LaserAttack1;
import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern3.LaserAttack2;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class BulletAttackSpawn {

    public SharedPreferences singleCursorActive;

    public Context con;
    public Cursor cursor;

    public Handler attackSwitchDelay;

    int first;
    int second;

    public BulletAttackSpawn(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    public int choose() {
        int choice;

        do{
            choice = (int)Math.floor(Math.random() * 3);
        }
        while (first == choice);

        return choice;
    }

    Runnable runnableRepeatAttacks = new Runnable() {
        @Override
        public void run() {

            BulletAttack1 bulletAttack1 = new BulletAttack1(con, cursor);
            LaserAttack1 laserAttack1 = new LaserAttack1(con, cursor);
            LaserAttack2 laserAttack2 = new LaserAttack2(con, cursor);

            first = choose();
            second = choose();

            if (first == 0 || second == 0) {
                bulletAttack1.initAttack();
            }
            if (first == 1 || second == 1) {
                laserAttack1.initAttack();
            }
            if (first == 2 || second == 2) {
                laserAttack2.initAttack();
            }


            if (singleCursorActive.getBoolean("singleCursorActive", true)) {
                attackSwitchDelay.postDelayed(runnableRepeatAttacks, 10000);
            }
            else {
                attackSwitchDelay.removeCallbacksAndMessages(null);
            }
        }
    };

    //periodically start different attack patterns
    public void startSpawn() {

        //Check if activity is still collide
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);

        attackSwitchDelay = new Handler();

        runnableRepeatAttacks.run();

    }
}
//TODO make a timed attack program
//TODO bulletpattern3 4 1/4 width lasers memory