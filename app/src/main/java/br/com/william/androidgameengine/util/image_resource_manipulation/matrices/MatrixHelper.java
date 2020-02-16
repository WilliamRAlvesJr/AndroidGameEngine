package br.com.william.androidgameengine.util.image_resource_manipulation.matrices;

public class MatrixHelper {

    private static final float[]
    identity = {
        1.0f, 0.0f, 0.0f, 0.0f,
        0.0f, 1.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 1.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f
    };

    public static float[] getIdentity() {
        return identity;
    }
}
