package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;

public class BulletAttack1 {

    Context con;

    public BulletAttack1 (Context con) {
        this.con = con;
    }
    public void initAttack() {

        Bullet1 bullet1 = new Bullet1();
        bullet1.init();
    }
}
