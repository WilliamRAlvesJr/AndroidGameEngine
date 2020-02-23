package br.com.william.androidgameengine;

import org.apache.commons.lang3.ArrayUtils;

public class GameObjectAttributesGuarantor {

    protected final int ID;

    private static float[] xAxis = {};
    private static float[] yAxis = {};
    private static float[] width = {};
    private static float[] height = {};
    private static float[] rotation = {};
    private static float[] speed = {};

    public GameObjectAttributesGuarantor(int id) {
        this.ID = id;

        if (rotation.length == 0)
            rotation = new float[ID + 1];
        if (xAxis.length == 0)
            xAxis = new float[ID + 1];
        if (yAxis.length == 0)
            yAxis = new float[ID + 1];
        if (width.length == 0)
            width = new float[ID + 1];
        if (height.length == 0)
            height = new float[ID + 1];
        if (speed.length == 0)
            speed = new float[ID + 1];

        if (rotation.length-1 < ID)
            rotation = ArrayUtils.addAll(rotation, new float[] { 0f });
        if (xAxis.length-1 < ID)
            xAxis = ArrayUtils.addAll(xAxis, new float[] { 0f });
        if (yAxis.length-1 < ID)
            yAxis = ArrayUtils.addAll(yAxis, new float[] { 0f });
        if (width.length-1 < ID)
            width = ArrayUtils.addAll(width, new float[] { 0f });
        if (height.length-1 < ID)
            height = ArrayUtils.addAll(height, new float[] { 0f });
        if (speed.length-1 < ID)
            speed = ArrayUtils.addAll(speed, new float[] { 0f });
    }

    public float getXAxis() {
        while(!(GameObjectAttributesGuarantor.xAxis.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return xAxis[ID];
    }

    public void setXAxis(float xAxis) {
        if (GameObjectAttributesGuarantor.xAxis.length > ID) {
            GameObjectAttributesGuarantor.xAxis[ID] = xAxis;
        }
    }

    public float getYAxis() {
        while(!(GameObjectAttributesGuarantor.yAxis.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return yAxis[ID];
    }

    public void setYAxis(float yAxis) {
        if (GameObjectAttributesGuarantor.yAxis.length > ID) {
            GameObjectAttributesGuarantor.yAxis[ID] = yAxis;
        }
    }

    public float getWidth() {
        while(!(GameObjectAttributesGuarantor.width.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return width[ID];
    }

    public void setWidth(float width) {
        if (GameObjectAttributesGuarantor.width.length > ID) {
            GameObjectAttributesGuarantor.width[ID] = width;
        }
    }

    public float getHeight() {
        while(!(GameObjectAttributesGuarantor.height.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return height[ID];
    }

    public void setHeight(float height) {
        if (GameObjectAttributesGuarantor.height.length > ID) {
            GameObjectAttributesGuarantor.height[ID] = height;
        }
    }

    public float getRotation() {
        while (!(GameObjectAttributesGuarantor.rotation.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return rotation[ID];
    }

    public void setRotation(float deegres) {
        if (GameObjectAttributesGuarantor.rotation.length > ID) {
            GameObjectAttributesGuarantor.rotation[ID] = deegres;
        }
    }

    public float getSpeed() {
        while (!(GameObjectAttributesGuarantor.speed.length > ID)) {
            GameLoop.stop();
            GameLoop.enableStart();
        }
        return speed[ID];
    }

    public void setSpeed(float speed) {
        if (GameObjectAttributesGuarantor.speed.length > ID) {
            GameObjectAttributesGuarantor.speed[ID] = speed;
        }
    }
}
