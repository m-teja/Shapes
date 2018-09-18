package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.Context;

public class BulletAttack1 {

    Context con;
    Cursor cursor;

    public BulletAttack1(Context con, Cursor cursor) {
        this.con = con;
        this.cursor = cursor;
    }
    public void initAttack() {

        Bullet1 bullet1 = new Bullet1(con, cursor);
        bullet1.init(500, 500);//put x and y here to make attack patterns
    }
}
