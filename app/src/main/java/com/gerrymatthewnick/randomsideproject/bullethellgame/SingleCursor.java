package com.gerrymatthewnick.randomsideproject.bullethellgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SingleCursor extends AppCompatActivity {

    public Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_cursor);

        cursor = new Cursor(this);
        cursor.init();
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
}
