package br.com.william.androidgameengine;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class Renderer {

    public static float unitsWide = 10;
    public static float unitsTall = 0;

    private static EngineSurfaceView surfaceView;
    private static boolean rendererSet = false;

    public static void init(Context context) {
        surfaceView = new EngineSurfaceView(context);
        if (surfaceView == null) {
            return;
        }

        surfaceView.setEventListener(new EngineEventListener());
        surfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        surfaceView.setOnTouchListener(new EngineTouchListener());

        rendererSet = true;
    }

    public static void render() {
        surfaceView.requestRender();
    }

    public static EngineSurfaceView getSurfaceView() {
        return surfaceView;
    }

    public static boolean isRendererSet() {
        return rendererSet;
    }
}
