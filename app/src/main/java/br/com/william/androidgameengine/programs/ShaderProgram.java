package br.com.william.androidgameengine.programs;

import android.content.Context;

import br.com.william.androidgameengine.util.image_resource_manipulation.shaders.ShaderHelper;
import br.com.william.androidgameengine.util.image_resource_manipulation.textures.TextResourceReader;

import static android.opengl.GLES30.glUseProgram;

public abstract class ShaderProgram {

    // Uniform constants
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String U_COLOR = "u_Color";

    // Attribute constants
    protected static final String A_COLOR = "a_Color";
    protected static final String A_POSITION = "a_Position";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    // Shader program
    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        // Compile the shaders and link the program.
        program = ShaderHelper.buildProgram(
            TextResourceReader.readTextFileFromResource( context, vertexShaderResourceId),
            TextResourceReader.readTextFileFromResource( context, fragmentShaderResourceId)
        );
    }

    public void useProgram() {
        // Set the current OpenGL shader program to this program.
        glUseProgram(program);
    }

    public abstract int getExtraComponentAttributeLocation();

    public abstract int getPositionAttributeLocation();
}