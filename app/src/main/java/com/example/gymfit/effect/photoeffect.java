package com.example.gymfit.effect;

import android.graphics.Bitmap;
import android.graphics.Color;

public class photoeffect {
    public static Bitmap addEffect(Bitmap src, int depth, double red, double green, double blue) {

        int width = src.getWidth();
        int height = src.getHeight();

        Bitmap finalBitmap = Bitmap.createBitmap(width, height, src.getConfig());

        final double grayScale_Red = 0.3;
        final double grayScale_Green = 0.59;
        final double grayScale_Blue = 0.11;

        int channel_aplha, channel_red, channel_green, channel_blue;
        int pixel;

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {

                pixel = src.getPixel(x, y);
                channel_aplha = Color.alpha(pixel);
                channel_red = Color.red(pixel);
                channel_green = Color.green(pixel);
                channel_blue = Color.blue(pixel);

                channel_blue = channel_green = channel_red = (int) (grayScale_Red * channel_red + grayScale_Green * channel_green + grayScale_Blue * channel_blue);

                channel_red += (depth * red);
                if (channel_red > 255) {
                    channel_red = 255;
                }
                channel_green += (depth * green);
                if (channel_green > 255) {
                    channel_green = 255;
                }
                channel_blue += (depth * blue);
                if (channel_blue > 255) {
                    channel_blue = 255;
                }

                finalBitmap.setPixel(x, y, Color.argb(channel_aplha, channel_red, channel_green, channel_blue));
            }
        }
        return finalBitmap;
    }
}