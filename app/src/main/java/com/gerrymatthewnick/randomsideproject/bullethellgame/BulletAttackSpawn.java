package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;
import android.content.SharedPreferences;

import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern1.BulletAttack1;
import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern2.LaserAttack1;
import com.gerrymatthewnick.randomsideproject.bullethellgame.BulletPattern3.LaserAttack2;

import static android.content.Context.MODE_PRIVATE;
import static com.gerrymatthewnick.randomsideproject.bullethellgame.SingleCursor.PREFERENCES_SINGLE_CURSOR_ACTIVE;

public class BulletAttackSpawn {

    public SharedPreferences singleCursorActive;

    public Context con;
    public Cursor cursor;



    public BulletAttackSpawn(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    //periodically start different attack patterns
    public void startSpawn() {

        //Check if activity is still collide
        singleCursorActive = con.getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        if (singleCursorActive.getBoolean("singleCursorActive", true)) {

            //randomly placed bullets
           // BulletAttack1 bulletAttack1 = new BulletAttack1(con, cursor);
          //  bulletAttack1.initAttack();

            //tracking lasers
        //    LaserAttack1 laserAttack1 = new LaserAttack1(con, cursor);
         //   laserAttack1.initAttack();

            // 1/4 screen width lasers
            LaserAttack2 laserAttack2 = new LaserAttack2(con, cursor);
            laserAttack2.initAttack();
        }
    }
}
//TODO make a timed attack program
//TODO bulletpattern3 4 1/4 width lasers memory