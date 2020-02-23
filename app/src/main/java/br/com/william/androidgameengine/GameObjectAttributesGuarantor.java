package br.com.william.androidgameengine;

public class GameObjectAttributes {

    protected final int ID;
    private static float[] xAxis = {};
    private static float[] yAxis = {};
    private static float[] width = {};
    private static float[] height = {};
    private static float[] rotation = {};
    private static float[] speed = {};

    public GameObjectAttributes(int id) {
        this.ID = id;

        rotation = new float[ID+1];
        xAxis = new float[ID+1];
        yAxis = new float[ID+1];
        width = new float[ID+1];
        height = new float[ID+1];
        speed = new float[ID+1];
    }

    public float getXAxis() {
        while(!(GameObjectAttributes.xAxis.length > ID)) {
            GameLoop.pause();
            GameLoop.resume();
        }
        return xAxis[ID];
    }

    public void setXAxis(float xAxis) {
        if (GameObjectAttributes.xAxis.length > ID) {
            GameObjectAttributes.xAxis[ID] = xAxis;
        }
    }

    public float getYAxis() {
        while(!(GameObjectAttributes.yAxis.length > ID)) {
            GameLoop.pause();
            GameLoop.resume();
        }
        return yAxis[ID];
    }

    public void setYAxis(float yAxis) {
        if (GameObjectAttributes.yAxis.length > ID) {
            GameObjectAttributes.yAxis[ID] = yAxis;
        }
    }

    public float getWidth() {
        while(!(GameObjectAttributes.width.length > ID)) {
            GameLoop.pause();
            GameLoop.resume();
        }
        return width[ID];
    }

    public void setWidth(float width) {
        if (GameObjectAttributes.width.length > ID) {
            GameObjectAttributes.width[ID] = width;
        }
    }

    public float getHeight() {
        while(!(GameObjectAttributes.height.length > ID)) {
            GameLoop.pause();
            GameLoop.resume();
        }
        return height[ID];
    }

    public void setHeight(float height) {
        if (GameObjectAttributes.height.length > ID) {
            GameObjectAttributes.height[ID] = height;
        }
    }

    public float getRotation() {
        while (!(GameObjectAttributes.rotation.length > ID)) {
            GameLoop.pause();
            GameLoop.resume();
        }
        return rotation[ID];
    }

    public void setRotation(float deegres) {
        if (GameObjectAttributes.rotation.length > ID) {
            GameObjectAttributes.rotation[ID] = deegres;
        }
    }
}
