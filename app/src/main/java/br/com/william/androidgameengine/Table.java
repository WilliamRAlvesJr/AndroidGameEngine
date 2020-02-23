package br.com.william.androidgameengine;

import org.apache.commons.lang3.ArrayUtils;

import br.com.william.androidgameengine.data.VertexArray;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static android.opengl.GLES30.GL_TRIANGLE_FAN;
import static android.opengl.GLES30.glDrawArrays;

public class Table {

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT + TEXTURE_COORDINATES_COMPONENT_COUNT) * Constants.BYTES_PER_FLOAT;
    public static float[] vertexData = new float[] {};

    private final VertexArray vertexArray;

    public Table(float[] coordinates) {
        this.vertexData = ArrayUtils.addAll(vertexData, coordinates);
        vertexArray = new VertexArray(coordinates);
    }
    public void bindData(TextureShaderProgram textureProgram) {
        vertexArray.setVertexAttribPointer(0, textureProgram.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, STRIDE);
        vertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, textureProgram.getExtraComponentAttributeLocation(), TEXTURE_COORDINATES_COMPONENT_COUNT, STRIDE);
    }

    public void draw() {
        glDrawArrays(GL_TRIANGLE_FAN, 0, 6);
    }
}