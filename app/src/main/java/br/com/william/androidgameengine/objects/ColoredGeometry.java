package br.com.william.androidgameengine.objects;

import br.com.william.androidgameengine.data.VertexArray;
import br.com.william.androidgameengine.programs.ColorShaderProgram;

import static android.opengl.GLES30.*;
import static br.com.william.androidgameengine.Constants.BYTES_PER_FLOAT;

public class ColoredGeometry {

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int COLOR_COMPONENT_COUNT = 3;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT) * BYTES_PER_FLOAT;
    private static int elements;
    private static int glType;

    private static float[] VERTEX_DATA = {
        // Order of coordinates: X, Y, R, G, B
    };

    private final VertexArray vertexArray;

    public ColoredGeometry(float[] coordinates, int elements, int glType) {
        this.elements = elements;
        this.glType = glType;
        VERTEX_DATA = coordinates;
        vertexArray = new VertexArray(VERTEX_DATA);
    }

    public ColoredGeometry() {
        vertexArray = new VertexArray(VERTEX_DATA);
    }

    public void bindData(ColorShaderProgram colorProgram) {
        vertexArray.setVertexAttribPointer(0, colorProgram.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, STRIDE);
//        vertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, colorProgram.getColorAttributeLocation(), COLOR_COMPONENT_COUNT, STRIDE);
    }

    public static void setVertexData(float[] vertexData) {
        VERTEX_DATA = vertexData;
    }

    public void draw() {
        glDrawArrays(glType, 0, elements);
    }

    public static float[] getVertexData() {
        return VERTEX_DATA;
    }

    public ColoredGeometry changeCoordinates(int count, float value) {
        VERTEX_DATA[count] = value;
        return this;
    }
}
