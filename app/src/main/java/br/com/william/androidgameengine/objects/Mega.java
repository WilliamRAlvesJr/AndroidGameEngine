package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.ShaderProgramsList;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static br.com.william.androidgameengine.Matrices.modelViewProjectionMatrix;
import static br.com.william.androidgameengine.Matrices.rotate;
import static br.com.william.androidgameengine.Matrices.translate;

public class Mega extends GameObject {

    private float xAxis  = 0f;
    private float yAxis  = 0f;
    private float width  = 0f;
    private float height = 0f;
    private float rotation = 0f;

    private float speed = 5f;
    public int megaTexture;

    public Mega(float[] coordinates, int shaderProgramId) {
        super(coordinates, shaderProgramId);
    }

    public void render() {
        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        translate(xAxis, yAxis, height, width);
        rotate(rotation);
        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        ((TextureShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId)).setUniforms(modelViewProjectionMatrix, megaTexture);
        bindData((TextureShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId));
        draw();
    }

    public void update() {}

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
