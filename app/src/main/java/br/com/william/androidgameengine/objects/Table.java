package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.data.VertexArray;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static android.opengl.GLES30.GL_TRIANGLE_FAN;
import static android.opengl.GLES30.glDrawArrays;
import static br.com.william.androidgameengine.Constants.BYTES_PER_FLOAT;

public class Table {

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT + TEXTURE_COORDINATES_COMPONENT_COUNT) * BYTES_PER_FLOAT;

    private static final float[] VERTEX_DATA = {
            // Order of coordinates: X, Y, S, T

            // Triangle Fan
            0f, 0f,
                0.5f, 0.5f,
            -0.5f, -0.8f,
                0f, 1.0f,
            0.5f, -0.8f,
                1f, 1.0f,
            0.5f, 0.8f,
                1f, 0.0f,
            -0.5f, 0.8f,
                0f, 0.0f,
            -0.5f, -0.8f,
                0f, 1.0f
    };

    private final VertexArray vertexArray;

    public Table() {
        vertexArray = new VertexArray(VERTEX_DATA);
    }

    public void bindData(TextureShaderProgram textureProgram) {
        vertexArray.setVertexAttribPointer(0, textureProgram.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, STRIDE);
//        vertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, textureProgram.getTextureCoordinatesAttributeLocation(), TEXTURE_COORDINATES_COMPONENT_COUNT, STRIDE);
    }

    public void draw() {
        glDrawArrays(GL_TRIANGLE_FAN, 0, 6);
    }
}