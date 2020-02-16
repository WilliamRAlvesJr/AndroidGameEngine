package br.com.william.androidgameengine;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class EngineTouchListener implements View.OnTouchListener {

    boolean isPressed = false;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event != null) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                isPressed = true;
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                isPressed = false;
            }
            Log.i("", ""+isPressed);
        }
        return true;
    }
}
