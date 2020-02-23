package br.com.william.androidgameengine;

import br.com.william.androidgameengine.objects.Geometry;
import br.com.william.androidgameengine.programs.ColorShaderProgram;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static android.opengl.GLES30.GL_LINES;
import static android.opengl.GLES30.GL_TRIANGLE_FAN;
import static br.com.william.androidgameengine.EngineSurfaceView.getSurfaceViewContext;
import static br.com.william.androidgameengine.EngineWorld.addGameObject;
import static br.com.william.androidgameengine.ShaderProgramsList.addShaderProgram;

public class Scene_TEST implements SceneBlueprint {

    public static int COLOR_PROGRAM_ID;
    public static int TEXTURE_PROGRAM_ID;
    public static boolean isRunning;

    @Override
    public void start() {
        TEXTURE_PROGRAM_ID = addShaderProgram(new TextureShaderProgram(getSurfaceViewContext()));
        COLOR_PROGRAM_ID = addShaderProgram(new ColorShaderProgram(getSurfaceViewContext()));

//        GameObject table = new Mega(new float[] {
//            0f, 0f,         0.5f, 0.5f,
//            -0.5f, -0.8f,   0f, 1.0f,
//            0.5f, -0.8f,    1f, 1.0f,
//            0.5f, 0.8f,     1f, 0.0f,
//            -0.5f, 0.8f,    0f, 0.0f,
//            -0.5f, -0.8f,   0f, 1.0f
//        }, TEXTURE_PROGRAM_ID);

        Geometry lineX = new Geometry(new float[] {
                -3.0f, 0.0f,    1f, 1f, 1f,
                3.0f, 0.0f,     1f, 1f, 1f
        }, GL_LINES, COLOR_PROGRAM_ID);

        Geometry lineY = new Geometry(new float[] {
                0.0f, -3.0f,    1f, 1f, 1f,
                0.0f, 3.0f,     1f, 1f, 1f
        }, GL_LINES, COLOR_PROGRAM_ID){

            @Override
            public void update() {
                setRotation(getRotation() - 0.1f);
//                setXAxis(getXAxis() + 0.01f);
            }

            @Override
            public void reset() {
            }
        };

        Geometry triangle = new Geometry(new float[] {
                0.0f, -0.5f,    1f, 0f, 0f,
                -0.5f, 0.5f,    0f, 1f, 0f,
                0.5f, 0.5f,     0f, 0f, 1f
        }, GL_TRIANGLE_FAN, COLOR_PROGRAM_ID) {

            @Override
            public void update() {

                setRotation(getRotation() + 1f);
//                float value = getXAxis() + 0.0001f;
//
//                setXAxis(value);
//                setxCameraAxis(value);
//
//                setYAxis(value);
//                setyCameraAxis(value);
            }
        };

        addGameObject(lineX);
        addGameObject(lineY);
        addGameObject(triangle);
//        addGameObject(table);

        isRunning = true;
    }
}
