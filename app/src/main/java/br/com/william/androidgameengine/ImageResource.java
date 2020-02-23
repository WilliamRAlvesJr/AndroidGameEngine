package br.com.william.androidgameengine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import br.com.william.androidgameengine.util.logger.LoggerConfig;

import static android.opengl.GLES30.GL_LINEAR;
import static android.opengl.GLES30.GL_LINEAR_MIPMAP_LINEAR;
import static android.opengl.GLES30.GL_TEXTURE_2D;
import static android.opengl.GLES30.GL_TEXTURE_MAG_FILTER;
import static android.opengl.GLES30.GL_TEXTURE_MIN_FILTER;
import static android.opengl.GLES30.glBindTexture;
import static android.opengl.GLES30.glDeleteTextures;
import static android.opengl.GLES30.glGenTextures;
import static android.opengl.GLES30.glGenerateMipmap;
import static android.opengl.GLES30.glTexParameteri;
import static android.opengl.GLUtils.texImage2D;

public class ImageResource {

    private static final String TAG = "ImageResource";

    private static Bitmap bitmap;

    public static int loadTexture(String path) {

        final int[] textureObjectIds = new int[1];
        glGenTextures(1, textureObjectIds, 0);
        if (textureObjectIds[0] == 0) {
            if (LoggerConfig.ON) {
                Log.w(TAG, "Could not generate a new OpenGL texture object.");
            }
            return 0;
        }

        try {
            URL url = ImageResource.class.getResource(path);
            bitmap = BitmapFactory.decodeStream(url.openStream());

            if (bitmap == null) {
                if (LoggerConfig.ON) {
                    Log.w(TAG, "Resource " + path + " could not be decoded.");
                }
                glDeleteTextures(1, textureObjectIds, 0);
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        glBindTexture(GL_TEXTURE_2D, textureObjectIds[0]);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();

        glGenerateMipmap(GL_TEXTURE_2D);

        glBindTexture(GL_TEXTURE_2D, 0);

        return textureObjectIds[0];
    }
}
