package br.com.william.androidgameengine.objects;

import static br.com.william.androidgameengine.Constants.BYTES_PER_FLOAT;

interface DrawableParameters {

    int POSITION_COMPONENT_COUNT = 2;

    int COLOR_COMPONENT_COUNT = 3;
    int TEXTURE_COMPONENT_COUNT = 2;

    int STRIDE_COLOR = (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT) * BYTES_PER_FLOAT;
    int STRIDE_TEXTURE = (POSITION_COMPONENT_COUNT + TEXTURE_COMPONENT_COUNT) * BYTES_PER_FLOAT;
}
