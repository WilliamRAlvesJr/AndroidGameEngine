package br.com.william.androidgameengine.util;

public class EngineCamera {

    private static float xCameraAxis = 0f;
    private static float yCameraAxis = 0f;
    private static float xCameraZoom = 0f;
    private static float yCameraZoom = 0f;
    private static float cameraRotation = 0f;

    public static float getxCameraAxis() {
        return xCameraAxis;
    }

    public static void setxCameraAxis(float xCameraAxis) {
        EngineCamera.xCameraAxis = xCameraAxis;
    }

    public static float getyCameraAxis() {
        return yCameraAxis;
    }

    public static void setyCameraAxis(float yCameraAxis) {
        EngineCamera.yCameraAxis = yCameraAxis;
    }

    public static float getxCameraZoom() {
        return xCameraZoom;
    }

    public static void setxCameraZoom(float xCameraZoom) {
        EngineCamera.xCameraZoom = xCameraZoom;
    }

    public static float getyCameraZoom() {
        return yCameraZoom;
    }

    public static void setyCameraZoom(float yCameraZoom) {
        EngineCamera.yCameraZoom = yCameraZoom;
    }

    public static float getCameraRotation() {
        return cameraRotation;
    }

    public static void setCameraRotation(float cameraRotation) {
        EngineCamera.cameraRotation = cameraRotation;
    }
}
