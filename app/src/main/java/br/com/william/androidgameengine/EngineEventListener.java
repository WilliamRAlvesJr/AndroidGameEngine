package br.com.william.androidgameengine;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import br.com.william.androidgameengine.util.EngineCamera;

import static android.opengl.GLES30.GL_BLEND;
import static android.opengl.GLES30.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES30.GL_ONE_MINUS_SRC_ALPHA;
import static android.opengl.GLES30.GL_SRC_ALPHA;
import static android.opengl.GLES30.glBlendFunc;
import static android.opengl.GLES30.glClear;
import static android.opengl.GLES30.glClearColor;
import static android.opengl.GLES30.glEnable;
import static android.opengl.GLES30.glViewport;
import static android.opengl.Matrix.multiplyMM;
import static android.opengl.Matrix.orthoM;
import static android.opengl.Matrix.setIdentityM;
import static br.com.william.androidgameengine.Matrices.projectionMatrix;
import static br.com.william.androidgameengine.Matrices.viewMatrix;
import static br.com.william.androidgameengine.Matrices.viewProjectionMatrix;
import static br.com.william.androidgameengine.Renderer.unitsTall;
import static br.com.william.androidgameengine.Renderer.unitsWide;

public class EngineEventListener implements GLSurfaceView.Renderer {

    private static int height;
    private static int width;

    @Override
    public void onDrawFrame(GL10 unused) {

        glClear(GL_COLOR_BUFFER_BIT);

        Matrices.translateWorld(-EngineCamera.getxCameraAxis(), -EngineCamera.getyCameraAxis(),
                                EngineCamera.getxCameraZoom(), EngineCamera.getyCameraZoom());
        Matrices.rotateWorld(EngineCamera.getCameraRotation());
        multiplyMM(viewProjectionMatrix, 0, projectionMatrix, 0, viewMatrix, 0);

        EngineWorld.render();
        Matrices.translateWorld(EngineCamera.getxCameraAxis(), EngineCamera.getyCameraAxis(),
                                -EngineCamera.getxCameraZoom(), -EngineCamera.getyCameraZoom());
        Matrices.rotateWorld(-EngineCamera.getCameraRotation());
    }

    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        EngineWorld.init(EngineSurfaceView.getSurfaceViewContext());
    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        glViewport(0, 0, width, height);

        this.height = height;
        this.width = width;
        setIdentityM(projectionMatrix, 0);

        if (width > height) {
            // Landscape
            unitsTall = height / (width / unitsWide);
            orthoM(projectionMatrix, 0, -unitsWide / 2, unitsWide / 2, -unitsTall / 2, unitsTall / 2, 0, 1);
        } else {
            // Portrait or square
            unitsTall = width / (height / unitsWide);
            orthoM(projectionMatrix, 0, -unitsTall / 2, unitsTall / 2, -unitsWide / 2, unitsWide / 2, 0, 1);
        }

        setIdentityM(viewMatrix, 0);

        EngineWorld.reset();
    }
}


