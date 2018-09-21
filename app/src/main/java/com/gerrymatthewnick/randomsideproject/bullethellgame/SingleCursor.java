package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.squareup.leakcanary.LeakCanary;

public class SingleCursor extends AppCompatActivity {

    public static final String PREFERENCES_SINGLE_CURSOR_ACTIVE = "singleCursorActive";
    public SharedPreferences active;
    public SharedPreferences.Editor activeEditor;

    public Cursor cursor;
    public BulletAttackSpawn bulletAttackSpawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_cursor);

        /*
        //For testing purposes
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(getApplication());
*/
        active = getSharedPreferences(PREFERENCES_SINGLE_CURSOR_ACTIVE, MODE_PRIVATE);
        activeEditor = active.edit();

        //Sets the activity as collide
        setActive();

        //Spawns cursor
        initCursor();

        //Starts random bullet attack patterns
        initBulletAttack();
    }

    public void setActive() {
         activeEditor.putBoolean("singleCursorActive", true);
         activeEditor.apply();
    }

    public void initCursor() {
        cursor = new Cursor(this);
        cursor.init();
    }

    public void initBulletAttack() {
        bulletAttackSpawn = new BulletAttackSpawn(this, cursor);
        bulletAttackSpawn.startSpawn();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                cursor.setX(x);
                cursor.setY(y);
                break;

            case MotionEvent.ACTION_MOVE:
                cursor.setX(x);
                cursor.setY(y);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                break;
        }
        return false;
    }


    //Detect when activity stops and starts and sets collide to true or false
    @Override
    public void onStart() {
        super.onStart();
        activeEditor.putBoolean("singleCursorActive", true);
        activeEditor.apply();
    }

    @Override
    public void onStop() {
        super.onStop();
        activeEditor.putBoolean("singleCursorActive", false);
        activeEditor.apply();
    }

    @Override
    public void onPause() {
        super.onPause();
        activeEditor.putBoolean("singleCursorActive", false);
        activeEditor.apply();
    }
}
