package br.com.william.androidgameengine.graphics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.widget.Toast;

import br.com.william.androidgameengine.EngineEventListener;
import br.com.william.androidgameengine.EngineSurfaceView;

public class EngineSurfaceViewInitializer {

    public static EngineSurfaceView setEventListener(Context context, EngineEventListener eventListener) {
        EngineSurfaceView glSurfaceView = new EngineSurfaceView(context);

        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        final boolean supportsEs3 = configurationInfo.reqGlEsVersion >= 0x30000
                || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")));
        if (supportsEs3) {
            glSurfaceView.setEGLContextClientVersion(2);
            glSurfaceView.setRenderer(eventListener);
        } else {
            Toast.makeText(context, "This device does not support OpenGL ES 3.0.", Toast.LENGTH_LONG).show();
            return null;
        }
        return glSurfaceView;
    }
}
