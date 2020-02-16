package br.com.william.androidgameengine.objects;

import org.apache.commons.lang3.ArrayUtils;

import br.com.william.androidgameengine.data.VertexArray;
import br.com.william.androidgameengine.programs.ColorShaderProgram;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES30.glDrawArrays;
import static br.com.william.androidgameengine.Constants.BYTES_PER_FLOAT;

public abstract class GameObject {

    private static final int POSITION_COMPONENT_COUNT = 2;

    private static final int COLOR_COMPONENT_COUNT = 3;
    private static final int TEXTURE_COMPONENT_COUNT = 2;

    private static final int STRIDE_COLOR = (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT) * BYTES_PER_FLOAT;
    private static final int STRIDE_TEXTURE = (POSITION_COMPONENT_COUNT + TEXTURE_COMPONENT_COUNT) * BYTES_PER_FLOAT;

    private float[] vertexData = new float[] {};
    private VertexArray vertexArray;

    private int elements;
    private int glType;
    private int startDrawAt;

    protected int shaderProgramId;

    public GameObject(float[] coordinates, int glType, int shaderProgramId) {
        this.glType = glType;
        this.elements = (coordinates.length / 5);
        this.startDrawAt = (vertexData.length / 5);

        this.vertexData = ArrayUtils.addAll(vertexData, coordinates);
        this.vertexArray = new VertexArray(coordinates);
        this.shaderProgramId = shaderProgramId;
    }

    public GameObject(float[] coordinates, int shaderProgramId) {
        this.glType = GL_TRIANGLE_FAN;
        this.elements = 3 + (coordinates.length / 3);
        this.startDrawAt = (vertexData.length / 4);

        this.vertexData = ArrayUtils.addAll(vertexData, coordinates);
        this.vertexArray = new VertexArray(coordinates);
        this.shaderProgramId = shaderProgramId;
    }

    public void bindData(ColorShaderProgram colorShaderProgram) {
        vertexArray.setVertexAttribPointer(0, colorShaderProgram.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, STRIDE_COLOR);
        vertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, colorShaderProgram.getExtraComponentAttributeLocation(), COLOR_COMPONENT_COUNT, STRIDE_COLOR);
    }

    public void bindData(TextureShaderProgram textureShaderProgram) {
        vertexArray.setVertexAttribPointer(0, textureShaderProgram.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, STRIDE_TEXTURE);
        vertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, textureShaderProgram.getExtraComponentAttributeLocation(), TEXTURE_COMPONENT_COUNT, STRIDE_TEXTURE);
    }

    public void draw() {
        glDrawArrays(glType, startDrawAt, elements);
    }

    public abstract void reset();

    public abstract void render();

    public abstract void update();
}
