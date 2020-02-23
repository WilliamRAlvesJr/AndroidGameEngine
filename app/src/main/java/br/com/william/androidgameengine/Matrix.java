package br.com.william.androidgameengine;

import static android.opengl.Matrix.multiplyMM;
import static android.opengl.Matrix.setIdentityM;
import static br.com.william.androidgameengine.Renderer.unitsTall;
import static br.com.william.androidgameengine.Renderer.unitsWide;
import static br.com.william.androidgameengine.util.EngineCamera.getxCameraAxis;
import static br.com.william.androidgameengine.util.EngineCamera.getxCameraZoom;
import static br.com.william.androidgameengine.util.EngineCamera.getyCameraAxis;
import static br.com.william.androidgameengine.util.EngineCamera.getyCameraZoom;

public class Matrices {

    public static float[] modelMatrix = new float[16];
    public static float[] viewMatrix = new float[16];
    public static float[] projectionMatrix = new float[16];
    public static float[] modelViewMatrix = new float[16];
    public static float[] viewProjectionMatrix = new float[16];
    public static float[] modelViewProjectionMatrix = new float[16];

    public static void syncTranslate(float xAxis, float yAxis, float height, float width) {
        xAxis = xAxis / unitsWide * 2f;
        float cameraX = -getxCameraAxis() / unitsWide * 2f;
        yAxis = yAxis / unitsTall * 2f;
        float cameraY = -getyCameraAxis() / unitsTall * 2f;
        width = width / unitsWide * 2f;
        float cameraXZoom = getxCameraZoom() / unitsWide * 2f;
        height = height / unitsTall * 2f;
        float cameraYZoom = getyCameraZoom() / unitsTall * 2f;

        setIdentityM(modelMatrix, 0);
        setIdentityM(viewMatrix, 0);
        modelMatrix[3] += xAxis;
        viewMatrix[3] += cameraX;
        modelMatrix[7] += yAxis;
        viewMatrix[7] += cameraY;
        modelMatrix[0] += width;
        viewMatrix[0] += cameraXZoom;
        modelMatrix[5] += height;
        viewMatrix[5] += cameraYZoom;
        multiplyMM(modelViewMatrix, 0, viewMatrix, 0, modelMatrix, 0);
        multiplyMM(modelViewProjectionMatrix, 0, projectionMatrix, 0, modelViewMatrix, 0);
    }

    public static void translate(float xAxis, float yAxis, float height, float width) {
        setIdentityM(modelMatrix, 0);
        modelMatrix[3] += xAxis / unitsWide * 2f;
        modelMatrix[7] += yAxis / unitsTall * 2f;
        modelMatrix[0] += width / unitsWide * 2f;
        modelMatrix[5] += height / unitsTall * 2f;
        multiplyMM(modelViewMatrix, 0, viewMatrix, 0, modelMatrix, 0);
        multiplyMM(modelViewProjectionMatrix, 0, projectionMatrix, 0, modelViewMatrix, 0);
    }

    public static void translateWorld(float cameraViewX, float cameraViewY, float cameraZoomX, float cameraZoomY) {
        setIdentityM(viewMatrix, 0);
        viewMatrix[3] += cameraViewX / unitsWide * 2f;
        viewMatrix[7] += cameraViewY / unitsTall * 2f;
        viewMatrix[0] += cameraZoomX / unitsWide * 2f;
        viewMatrix[5] += cameraZoomY / unitsTall * 2f;
        multiplyMM(viewProjectionMatrix, 0, projectionMatrix, 0, viewMatrix, 0);
        multiplyMM(modelViewProjectionMatrix, 0, viewProjectionMatrix, 0, modelViewMatrix, 0);
    }

    public static void rotate(float degrees) {
        float[] rotationMatrix = new float[16];
        setIdentityM(rotationMatrix, 0);
        rotationMatrix[0] = (float) Math.cos(Math.toRadians(degrees));
        rotationMatrix[1] = (float) -Math.sin(Math.toRadians(degrees));
        rotationMatrix[4] = (float) Math.sin(Math.toRadians(degrees));
        rotationMatrix[5] = (float) Math.cos(Math.toRadians(degrees));
        multiplyMM(modelMatrix, 0, rotationMatrix, 0, modelMatrix , 0);
//        multiplyMM(modelViewMatrix, 0, modelMatrix, 0, viewMatrix, 0);
        multiplyMM(modelViewProjectionMatrix, 0, modelViewMatrix, 0, projectionMatrix, 0);
    }

    public static void rotateWorld(float degrees) {
        float[] rotationMatrix = new float[16];
        setIdentityM(rotationMatrix, 0);
        rotationMatrix[0] = (float) Math.cos(Math.toRadians(degrees));
        rotationMatrix[1] = (float) -Math.sin(Math.toRadians(degrees));
        rotationMatrix[4] = (float) Math.sin(Math.toRadians(degrees));
        rotationMatrix[5] = (float) Math.cos(Math.toRadians(degrees));
        multiplyMM(viewMatrix, 0, rotationMatrix, 0, viewMatrix, 0);
        multiplyMM(viewProjectionMatrix, 0, projectionMatrix, 0, viewMatrix, 0);
        multiplyMM(modelViewProjectionMatrix, 0, modelMatrix, 0, viewProjectionMatrix, 0);
    }
}
