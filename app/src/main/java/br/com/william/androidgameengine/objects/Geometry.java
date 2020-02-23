package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.ShaderProgramsList;
import br.com.william.androidgameengine.programs.ColorShaderProgram;

import static br.com.william.androidgameengine.Matrix.modelViewProjectionMatrix;
import static br.com.william.androidgameengine.Matrix.rotate;
import static br.com.william.androidgameengine.Matrix.syncTranslate;

public class Geometry extends GameObject {

    public Geometry(float[] coordinates, int glType, int shaderProgramId) {
        super(coordinates, glType, shaderProgramId);
    }

    public void render() {
        ShaderProgramsList.getShaderProgram(shaderProgramId).useProgram();
        syncTranslate(getXAxis(), getYAxis(), getHeight(), getWidth());
        rotate(getRotation());
        ((ColorShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId)).setUniforms(modelViewProjectionMatrix);
        bindData((ColorShaderProgram) ShaderProgramsList.getShaderProgram(shaderProgramId));
        draw();
    }

    public void update() {}

    public void reset() {}










//    public float getXAxis() {
//        return xAxis[ID];
//    }
//
//    public void setXAxis(float xAxis) {
//        if (GameObjectAttributesGuarantor.xAxis.length >= ID) {
//            GameObjectAttributesGuarantor.xAxis[ID] = xAxis;
//        }
//    }
//
//    public float getYAxis() {
//        return yAxis[ID];
//    }
//
//    public void setYAxis(float yAxis) {
//        if (GameObjectAttributesGuarantor.yAxis.length >= ID) {
//            GameObjectAttributesGuarantor.yAxis[ID] = yAxis;
//        }
//    }
//
//    public float getWidth() {
//        return width[ID];
//    }
//
//    public void setWidth(float width) {
//        if (GameObjectAttributesGuarantor.width.length >= ID) {
//            GameObjectAttributesGuarantor.width[ID] = width;
//        }
//    }
//
//    public float getHeight() {
//        return height[ID];
//    }
//
//    public void setHeight(float height) {
//        if (GameObjectAttributesGuarantor.height.length >= ID) {
//            GameObjectAttributesGuarantor.height[ID] = height;
//        }
//    }
//
//    public float getRotation() {
//        return rotation[ID];
//    }
//
//    public void setRotation(float deegres) {
//        if (GameObjectAttributesGuarantor.rotation.length >= ID) {
//            GameObjectAttributesGuarantor.rotation[ID] = deegres;
//        }
//    }
}
