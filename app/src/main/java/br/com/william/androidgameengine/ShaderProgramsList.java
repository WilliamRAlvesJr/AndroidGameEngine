package br.com.william.androidgameengine;

import java.util.Arrays;

import br.com.william.androidgameengine.programs.ShaderProgram;

public class ShaderProgramsList {

    public static ShaderProgram[] shaderPrograms = {};
    public static int idCounter = -1;

    public static int addShaderProgram(ShaderProgram shaderProgram) {
        idCounter++;

        shaderPrograms = Arrays.copyOf(shaderPrograms, shaderPrograms.length + 1);
        shaderPrograms[idCounter] = shaderProgram;

        return idCounter;
    }

    public static ShaderProgram getShaderProgram(int id) {
        return shaderPrograms[id];
    }
}
