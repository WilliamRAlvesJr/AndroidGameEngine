package br.com.william.androidgameengine;

import android.content.Context;

import java.util.concurrent.ConcurrentLinkedQueue;

import br.com.william.androidgameengine.objects.GameObject;
import br.com.william.androidgameengine.objects.Geometry;
import br.com.william.androidgameengine.objects.Mega;
import br.com.william.androidgameengine.programs.ColorShaderProgram;
import br.com.william.androidgameengine.programs.TextureShaderProgram;
import br.com.william.androidgameengine.util.image_resource_manipulation.textures.TextureHelper;

import static android.opengl.GLES20.GL_LINES;
import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static br.com.william.androidgameengine.Constants.COLOR_PROGRAM_ID;
import static br.com.william.androidgameengine.Constants.TEXTURE_PROGRAM_ID;

public class EngineWorld {

    private static ConcurrentLinkedQueue<GameObject> gameObjectList = new ConcurrentLinkedQueue<>();

    private static Mega table;
    private static int megaTexture;

    public static void init(Context context) {
        TEXTURE_PROGRAM_ID = ShaderProgramsList.addShaderProgram(new TextureShaderProgram(context));
        COLOR_PROGRAM_ID = ShaderProgramsList.addShaderProgram(new ColorShaderProgram(context));

        table = new Mega(new float[] {
            0f, 0f,         0.5f, 0.5f,
            -0.5f, -0.8f,   0f, 1.0f,
            0.5f, -0.8f,    1f, 1.0f,
            0.5f, 0.8f,     1f, 0.0f,
            -0.5f, 0.8f,    0f, 0.0f,
            -0.5f, -0.8f,   0f, 1.0f
        }, TEXTURE_PROGRAM_ID);
        megaTexture = TextureHelper.loadTexture(context, R.drawable.mega_man);

        Geometry triangle = new Geometry(new float[] {
                0.0f, -0.5f,    1f, 0f, 0f,
                -0.5f, 0.5f,    0f, 1f, 0f,
                0.5f, 0.5f,     0f, 0f, 1f
            }, GL_TRIANGLE_FAN, COLOR_PROGRAM_ID);

        Geometry lineX = new Geometry(
            new float[] {
                -3.0f, 0.0f,    0f, 1f, 0f,
                3.0f, 0.0f,     0f, 1f, 0f
            }, GL_LINES, COLOR_PROGRAM_ID);

        Geometry lineY = new Geometry(
            new float[] {
                    0.0f, -3.0f,    0f, 1f, 0f,
                    0.0f, 3.0f,     0f, 1f, 0f
            }, GL_LINES, COLOR_PROGRAM_ID);

        EngineWorld.addGameObject(triangle);
        EngineWorld.addGameObject(lineX);
        EngineWorld.addGameObject(lineY);
        EngineWorld.addGameObject(table);
        table.megaTexture = megaTexture;
    }






    public static void update() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.update();
        }
    }

    public static void render() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.render();
        }
    }

    public static void reset() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.reset();
        }
    }

    public static void addGameObject(GameObject gameObject) {
        gameObjectList.offer(gameObject);
    }
}
