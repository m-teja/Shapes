package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;

public class BulletAttackSpawn {

    public Context con;


    public BulletAttackSpawn(Context con) {
        this.con = con;
    }

    //periodically start different attack patterns
    public void startSpawn() {

        BulletAttack1 bulletAttack1 = new BulletAttack1(con);
        bulletAttack1.initAttack();
    }
}
