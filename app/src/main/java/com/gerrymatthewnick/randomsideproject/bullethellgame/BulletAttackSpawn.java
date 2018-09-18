package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;

public class BulletAttackSpawn {

    public Context con;
    public Cursor cursor;

    public BulletAttackSpawn(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }

    //periodically start different attack patterns
    public void startSpawn() {

        BulletAttack1 bulletAttack1 = new BulletAttack1(con, cursor);
        bulletAttack1.initAttack();
    }
}
