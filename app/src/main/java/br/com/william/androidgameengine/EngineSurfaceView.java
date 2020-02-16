package br.com.william.androidgameengine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.widget.Toast;

public class EngineSurfaceView extends GLSurfaceView {

    private static Context context;

    public EngineSurfaceView(Context context) {
        super(context);
        this.context = context;
    }

    public void setEventListener(EngineEventListener eventListener) {
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
            super.setEGLContextClientVersion(2);
            super.setRenderer(eventListener);
        } else {
            Toast.makeText(context, "This device does not support OpenGL ES 3.0.", Toast.LENGTH_LONG).show();
            return;
        }
    }




    public static Context getSurfaceViewContext() {
        return context;
    }
}
