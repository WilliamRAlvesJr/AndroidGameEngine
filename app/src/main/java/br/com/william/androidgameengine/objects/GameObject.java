package br.com.william.androidgameengine.objects;

import org.apache.commons.lang3.ArrayUtils;

import br.com.william.androidgameengine.GameObjectAttributesGuarantor;
import br.com.william.androidgameengine.data.VertexArray;
import br.com.william.androidgameengine.programs.ColorShaderProgram;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static android.opengl.GLES30.glDrawArrays;

public abstract class GameObject extends GameObjectAttributesGuarantor implements DrawableParameters {

    private static int elementCounter = 0;

    protected static float[][] vertexData;
    private VertexArray vertexArray;

    private int pointsToDraw;
    private int glType;

    protected int shaderProgramId;

    public GameObject(float[] coordinates, int glType, int shaderProgramId) {
        super(elementCounter);
        elementCounter++;

        this.glType = glType;
        this.pointsToDraw = (coordinates.length / 5);

        if (vertexData == null || vertexData.length == 0)
            this.vertexData = new float[ID + 1][coordinates.length];

        if (vertexData.length-1 < ID)
            this.vertexData = ArrayUtils.addAll(vertexData, new float[1][coordinates.length]);

        this.vertexData[ID] = ArrayUtils.addAll(vertexData[ID], coordinates);

        this.vertexArray = new VertexArray(coordinates);
        this.shaderProgramId = shaderProgramId;
    }

    public GameObject(float[] coordinates, int shaderProgramId) {
        super(0);
//
//        this.glType = GL_TRIANGLE_FAN;
//        this.pointsToDraw = 3 + (coordinates.length / 3);
//        this.startPointToDraw = (vertexData.length / 4);
//
//        this.vertexData = ArrayUtils.addAll(vertexData, coordinates);
//        this.vertexArray = new VertexArray(coordinates);
//        this.shaderProgramId = shaderProgramId;
//
//        if (this.pointsToDraw != (3 + (coordinates.length / 3))) {
//            rotation = new float[pointsToDraw];
//            xAxis = new float[pointsToDraw];
//            yAxis = new float[pointsToDraw];
//            width = new float[pointsToDraw];
//            height = new float[pointsToDraw];
//            speed = new float[pointsToDraw];
//        }
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
        glDrawArrays(glType, 0, pointsToDraw);
    }

    public void resetGameObject() {
        elementCounter = 0;
        vertexData = new float[][] {};
        reset();
    };

    public abstract void reset();

    public abstract void render();

    public abstract void update();
}
