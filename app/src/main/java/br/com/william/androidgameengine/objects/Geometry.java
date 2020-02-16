package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.ShaderProgramsList;
import br.com.william.androidgameengine.programs.ColorShaderProgram;

import static br.com.william.androidgameengine.Matrices.modelViewProjectionMatrix;
import static br.com.william.androidgameengine.Matrices.rotate;
import static br.com.william.androidgameengine.Matrices.translate;

public class Geometry extends GameObject {

    private float xAxis = 0f;
    private float yAxis = 0f;
    private float width = 0f;
    private float height = 0f;
    private float rotation = 0f;

    private float speed = 5f;

    public Geometry(float[] coordinates, int glType, int shaderProgramId) {
        super(coordinates, glType, shaderProgramId);
    }

    public void render() {
        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        translate(xAxis, yAxis, height, width);
        rotate(rotation);
        ((ColorShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId)).setUniforms(modelViewProjectionMatrix);
        bindData((ColorShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId));
        draw();
    }

    public void update() {
        rotation += 2f;
    }

    public void reset() {}










    public float getXAxis() {
        return xAxis;
    }

    public void setXAxis(float xAxis) {
        this.xAxis = xAxis;
    }

    public float getYAxis() {
        return yAxis;
    }

    public void setYAxis(float yAxis) {
        this.yAxis = yAxis;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
