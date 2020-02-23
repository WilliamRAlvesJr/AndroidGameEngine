package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.Animation;
import br.com.william.androidgameengine.ImageResource;
import br.com.william.androidgameengine.ShaderProgramsList;
import br.com.william.androidgameengine.programs.TextureShaderProgram;

import static br.com.william.androidgameengine.Matrix.modelViewProjectionMatrix;
import static br.com.william.androidgameengine.Matrix.translate;

public class Mega extends GameObject {

    private float xAxis  = 0f;
    private float yAxis  = 0f;
    private float width  = 0f;
    private float height = 0f;
    private float rotation = 0f;

    private float speed = 5f;
    public Animation[] animations;

    public Mega(float[] coordinates, int shaderProgramId) {
        super(coordinates, shaderProgramId);

        animations = new Animation[1];
        animations[0] = new Animation();

        animations[0].frames = new int[20];
        animations[0].fps = 15;

        for (int i = 0; i < animations[0].frames.length; i++) {
            animations[0].frames[i] = ImageResource.loadTexture("/res/drawable-v24/survivor_idle_rifle_" + String.valueOf(i).concat(".png"));
        }
    }
    public void render() {

        animations[0].play();

        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        translate(xAxis, yAxis, height, width);
//        rotate(rotation);
        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        ((TextureShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId)).setUniforms(modelViewProjectionMatrix, animations[0].getImage());
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
